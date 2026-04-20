package pro1.apiDataModel;

import com.google.gson.annotations.SerializedName;

import java.time.LocalDate;

public class Date {
    @SerializedName("value")
    public String value;

    public LocalDate toLocalDate() {
        try {
            return LocalDate.parse(value, java.time.format.DateTimeFormatter.ofPattern("d.M.yyyy"));
        } catch (Exception e) {
            return null;
        }
    }
}
