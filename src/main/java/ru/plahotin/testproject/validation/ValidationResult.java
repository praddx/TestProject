package ru.plahotin.testproject.validation;
import java.util.List;

public class ValidationResult {
    private List<FieldsInfo> error;

    public ValidationResult(List<FieldsInfo> error) {
        this.error = error;
    }

    public List<FieldsInfo> getError() {
        return error;
    }

    public void setError(List<FieldsInfo> error) {
        this.error = error;
    }

    public static class FieldsInfo {
        private String field;
        private List<String> text;

        public FieldsInfo(String field, List<String> text) {
            this.field = field;
            this.text = text;
        }

        public String getField() {
            return field;
        }

        public void setField(String field) {
            this.field = field;
        }

        public List<String> getText() {
            return text;
        }

        public void setText(List<String> text) {
            this.text = text;
        }
    }
}

