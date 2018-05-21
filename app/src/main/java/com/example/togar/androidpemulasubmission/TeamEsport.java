package com.example.togar.androidpemulasubmission;

import android.widget.EditText;

import java.util.ArrayList;

/*
 * Created by Togar on 1/15/2018.
 */

public class TeamEsport {
    public static String[][] data = new String[][]{
            {"Na'Vi",
                    "Natus Vincere",
                    "http://liquipedia.net/commons/images/thumb/d/d6/Natus_Vincere.png/600px-Natus_Vincere.png",

            },
            {"Liquid",
                    "Team Liquid",
                    "http://liquipedia.net/commons/images/thumb/0/07/Team_liquid_logo_2017.png/600px-Team_liquid_logo_2017.png"
            },
            {"Cloud9",
                    "Cloud 9",
                    "http://liquipedia.net/commons/images/thumb/8/89/C9.png/600px-C9.png"
            },
            {"NIP",
                    "Ninjas in Pyjamas",
                    "http://esports-marketing-blog.com/wp-content/uploads/esport-content-marketing-ninjas-in-pyjamas.jpg"
            },
            {"EG",
                    "Evil Geniuses",
                    "http://liquipedia.net/commons/images/thumb/1/1a/EG.png/600px-EG.png"
            }
    };

    public static ArrayList<Esport> getListData(){
        Esport esport= null;
        ArrayList<Esport> list = new ArrayList<>();
        for (int i = 0; i <data.length; i++) {
            esport = new Esport();
            esport.setName(data[i][0]);
            esport.setRemarks(data[i][1]);
            esport.setPhoto(data[i][2]);

            list.add(esport);
        }

        return list;
    }
}

class Esport {
    private String name, remarks, photo;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }
}
