package com.nice.wealthrating;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Vector;

public class RichDB {
    Vector<Rich> richVector;

    public RichDB() {
        this.richVector = new Vector<Rich>();
    }

    List<Rich> findAll() {
        return Collections.list(richVector.elements());
    }

    Rich findById(String id) {
        Rich obj = null;
        for (Integer i = 0; i < richVector.size(); i++)
        {
            obj = richVector.get(i);
            if (id.equals(obj.getId())) {
                break;
            }
            obj = null;
        }
        return obj;
    }

    void save(Rich new_obj) {
        for (Integer i = 0; i < richVector.size(); i++)
        {
            if (new_obj.getId().equals(richVector.get(i).getId())) {
                richVector.remove(richVector.get(i));
                break;
            }
        }

        // Add object to vector.
        richVector.add(new_obj);
    }

}
