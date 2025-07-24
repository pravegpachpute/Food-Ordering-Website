package com.floobyte.franchise.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UpdatePasswordResponse {

    @JsonProperty("msg")
    private  String msg;
    @JsonProperty("user-email")
    private  String email;


        // Private constructor to force the use of the builder
        private UpdatePasswordResponse(String email, String msg) {
            this.email = email;
            this.msg = msg;
        }

        // Getters
        public String getEmail() {
            return email;
        }

        public String getMsg() {
            return msg;
        }

        // Builder class
        public static class Builder {
            private String email;
            private String msg;

            public Builder email(String email) {
                this.email = email;
                return this;
            }

            public Builder msg(String msg) {
                this.msg = msg;
                return this;
            }

            public UpdatePasswordResponse build() {
                return new UpdatePasswordResponse(this.email, this.msg);
            }
        }

        // Static method to create a builder
        public static Builder builder() {
            return new Builder();
        }

}
