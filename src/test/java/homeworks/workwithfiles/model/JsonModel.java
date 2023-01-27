package homeworks.workwithfiles.model;

import com.google.gson.annotations.SerializedName;

public class JsonModel {

    @SerializedName("menu")
    public Menu menu;

    static public class Menu {
        public Integer id;
        public String value;

        @SerializedName("popup")
        public Popup popup;

        static public class Popup {
            public String[] menuitem;
        }
    }

}
