package com.cvshealth.mscoe.common.types;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public abstract class APIException extends Exception {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String code;
    private String instance;
    private String title;
    private String reason;
    private String pointer;
    private Exception[] innerExceptions;

    private static final String GENERIC_Exception_MSG = "Generic Exception Message that should have been changed";

    private static String getExceptionReport(Exception err) {
        return (err.getStackTrace().length > 0) ? err.getStackTrace()[0].toString() : "";
    }

    public APIException(String code, String instance, String title, String reason, String pointer, Exception... innerExceptions) {
        super(reason);

        if (reason == null || reason.isEmpty()) {
            reason = GENERIC_Exception_MSG;
        }

        this.code = code;
        this.instance = instance;
        this.title = title;
        this.reason = reason;
        this.pointer = pointer;

        if (innerExceptions.length == 1) {
            Exception innerException = toException(innerExceptions[0]);
            this.innerExceptions = new Exception[] { innerException };
            String errReport = getExceptionReport(innerException);
            this.setStackTrace(new StackTraceElement[] { new StackTraceElement(errReport, "", "", 0) });
            return;
        }

        this.innerExceptions = new Exception[innerExceptions.length];
        String[] innerExceptionReports = new String[innerExceptions.length];

        for (int i = 0; i < innerExceptions.length; i++) {
            Exception Exception = toException(innerExceptions[i]);
            this.innerExceptions[i] = Exception;
            String errReport = getExceptionReport(Exception);
            innerExceptionReports[i] = "======= INNER Exception (" + (i + 1) + " of " + innerExceptions.length + ") =======\n\n" + errReport;
        }

        String thisExceptionReport = getExceptionReport(this);
        String stackTrace = thisExceptionReport + "\n\n" + String.join("\n\n", innerExceptionReports);
        this.setStackTrace(new StackTraceElement[] { new StackTraceElement(stackTrace, "", "", 0) });
    }

    public APIException withPointer(String value) {
        this.pointer = value;
        return this;
    }

    public String getPointer() {
        return this.pointer != null ? this.pointer : "";
    }

    public APIException withReason(String value) {
        this.reason = value;
      
        return this;
    }

    public String getReason() {
        return this.reason != null ? this.reason : "";
    }

    public APIException withTitle(String value) {
        this.title = value;
        return this;
    }

    public String getTitle() {
        return this.title != null ? this.title : "";
    }

    public APIException withInstance(String value) {
        try {
            UUID.fromString(value);
            this.instance = value;
        } catch (Exception e) {
            throw new IllegalArgumentException("Instance Must be UUID");
        }

        return this;
    }

    public String getInstance() {
        if (this.instance == null) {
            this.instance = UUID.randomUUID().toString();
        }

        return "urn:uuid:" + this.instance;
    }

    public APIException withCode(String value) {
        this.code = value;
        return this;
    }

    public String getCode() {
        return this.code;
    }

    private Exception toException(Object obj) {
        if (obj instanceof Exception) {
            return (Exception) obj;
        } else {
            String message = obj.toString();
            return new Exception(message);
        }
    }
    

    public Map<String, Object> toJson() {
        Map<String, Object> json = new HashMap<>();
        json.put("code", this.code);
        json.put("instance", "urn:uuid:" + this.instance);
        json.put("pointer", this.pointer);
        json.put("title", this.title);
        json.put("reason", this.reason);

        List<Map<String, Object>> rootCauses = new ArrayList<>();
        for (Object err : this.innerExceptions) {
            if (err instanceof APIException) {
            	APIException apiException = (APIException) err;
                Map<String, Object> rootCause = new HashMap<>();
                rootCause.put("code", apiException.code);
                rootCause.put("instance", "urn:uuid:" + apiException.instance);
                rootCause.put("pointer", apiException.pointer);
                rootCause.put("title", apiException.title);
                rootCause.put("reason", apiException.reason);
                rootCauses.add(rootCause);
            } else {
                Map<String, Object> rootCause = new HashMap<>();
                rootCause.put("code", "GENERIC-10T");
                rootCause.put("instance", "");
                rootCause.put("title", "Generic Error");
                rootCause.put("reason", ((Error) err).getMessage());
                rootCauses.add(rootCause);
            }
        }
        json.put("rootCauses", rootCauses);

        return json;
    }
    
    

}

