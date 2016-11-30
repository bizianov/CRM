package project.model.tourist;

/**
 * Created by slava23 on 11/30/2016.
 */
public enum Source {

    REGULAR("regular customer"),
    WEBSITE("came from web site"),
    REFERRAL("someone recommended us"),
    CASUAL("passing by person");

    private String reason;

    Source(String reason) {
        this.reason = reason;
    }

    public String getReason() {
        return reason;
    }
}
