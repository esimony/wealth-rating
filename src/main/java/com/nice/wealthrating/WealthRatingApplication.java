package com.nice.wealthrating;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.nativex.json.JSONException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Objects;

@SpringBootApplication
@RestController
public class WealthRatingApplication {

    CentralBankApplication central_bank;
    RichDB db;

    public WealthRatingApplication() {
        this.db = new RichDB();
        this.central_bank = new CentralBankApplication();
    }

//    @Autowired
//    RichService richService;

    public static void main(String[] args) {
        SpringApplication.run(WealthRatingApplication.class, args);
    }

    @GetMapping("/wealth-rating/check-client")
    public String getClientStatus(@RequestParam(value = "client", defaultValue = "") String clientInfo) throws JSONException {

        System.out.println(clientInfo);

        // Set client details.
        ClientDetails client = new ClientDetails();
        String rc = client.setClientDetails(clientInfo);
        if (!rc.equals("OK"))
            return rc;

        // Call the central-bank API
        long evaluateResponse = central_bank.getEvaluation(client.getCity());
        long threshold = central_bank.getThreshold();

        // Calculate fortune
        Long Fortune = client.getCash() + client.getNumberOfAssets() * evaluateResponse;
        System.out.println(Fortune);

        // If the person's fortune is greater than the threshold, add person to DB.
        if (Fortune > threshold) {
            // Add to db.
            Rich obj = new Rich(client.getId(), client.getFirstName(), client.getLastName(), Fortune);
            db.save(obj);
//            richService.saveOrUpdate(obj);

            return String.format("%s %s is rich!", client.getFirstName(), client.getLastName());
        } else {
            return String.format("%s %s is not rich.", client.getFirstName(), client.getLastName());
        }
    }

    // Get rich from DB
    @GetMapping("/wealth-rating/rich")
    public String getRichInfo(@RequestParam(value = "ID", defaultValue = "") String id) {
        String s = "";
        // If id is empty, return all Rich persisted in the DB.
        if (Objects.equals(id, "")) {
            List<Rich> l = db.findAll();
//            List<Rich> l = richService.getAll();
            for (int i = 0; i < l.size(); i++) {
                Rich obj = l.get(i);
                s += obj;
                if (i != l.size() - 1) {
                    s += ",\n";
                }
            }
        }
        // If ID is specified, return Rich details by ID.
        else {
            Rich obj = db.findById(id);
//            Rich obj = richService.getRichById(id);
            if (obj != null){
                s += obj.toString();
            }
        }

        return s;
    }

//    @Bean
//    public CommandLineRunner run(RichRepository repository) {
//        return (args) -> {
//            repository.save(new Rich("12345", "Eden", "Simony", 10000));
//            for (Rich rich : repository.findAll()) {
//                System.out.println(rich.toString());
//            }
//        };
//    }
}
