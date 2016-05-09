package com.example.avalo.mlexercise.utils;

public class Constants {

    public static final int PAYMENT_METHOD_FINISHED = 100;
    public static final int CARD_ISSUER_FINISHED = 200;
    public static final int INSTALLMENT_FINISHED = 300;

    public class Api {
        public static final String BASE_URL = "https://api.mercadopago.com/";
        public static final String VERSION = "v1/";
        public static final String PAYMENT = "payment_methods";
        public static final String CARD_ISSUERS = "/card_issuers";
        public static final String INSTALLMENTS = "/installments";
        public static final String URI_PAYMENT_METHOD = VERSION + PAYMENT;
        public static final String URI_PAYMENT_METHOD_CARD_ISSUERS = URI_PAYMENT_METHOD + CARD_ISSUERS;
        public static final String URI_PAYMENT_METHOD_INSTALLMENTS = URI_PAYMENT_METHOD + INSTALLMENTS;
        public static final String PUBLIC_KEY = "public_key";
        public static final String PAYMENT_METHOD_ID = "payment_method_id";
        public static final String ISSUER_ID = "issuer.id";
        public static final String AMOUNT = "amount";
        public static final String RECOMMENDED_MESSAGE = "recommended_message";
    }

    public class PaymentMethod {
        public static final String ID = "id";
        public static final String NAME = "name";
        public static final String PAYMENT_TYPE_ID = "payment_type_id";
        public static final String STATUS = "status";
        public static final String SECURE_THUMBNAIL = "secure_thumbnail";
        public static final String THUMBNAIL = "thumbnail";
        public static final String DEFERRED_CAPTURE = "deferred_capture";
        public static final String SETTINGS = "settings";
        public static final String ADDITIONAL_INFO_NEEDED = "additional_info_needed";
        public static final String MIN_ALLOWED_AMOUNT = "min_allowed_amount";
        public static final String MAX_ALLOWED_AMOUNT = "max_allowed_amount";
        public static final String ACCREDITATION_TIME = "accreditation_time";

        public class Setting {
            public static final String BIN = "bin";
            public static final String CARD_NUMBER = "card_number";
            public static final String SECURITY_CODE = "security_code";

            public class Bin {
                public static final String PATTERN = "pattern";
                public static final String EXCLUSION_PATTERN = "exclusion_pattern";
                public static final String INSTALLMENTS_PATTERN = "installments_pattern";
            }

            public class CardNumber {
                public static final String LENGTH = "length";
                public static final String VALIDATION = "validation";
            }

            public class SecurityCode {
                public static final String MODE = "mode";
                public static final String LENGTH = "length";
                public static final String CARD_LOCATION = "card_location";
            }
        }
    }

    public class CardIssuer {
        public static final String ID = "id";
        public static final String NAME = "name";
        public static final String SECURE_THUMBNAIL = "secure_thumbnail";
        public static final String THUMBNAIL = "thumbnail";
    }

    public class Installment {
        public static final String PAYMENT_METHOD_ID = "payment_method_id";
        public static final String PAYMENT_TYPE_ID = "payment_type_id";
        public static final String ISSUER = "issuer";
        public static final String PAYER_COSTS = "payer_costs";

        public class Issuer {
            public static final String ID = "id";
            public static final String NAME = "name";
            public static final String SECURE_THUMBNAIL = "secure_thumbnail";
            public static final String THUMBNAIL = "thumbnail";
        }

        public class PayerCost {
            public static final String INSTALLMENTS = "installments";
            public static final String INSTALLMENT_RATE = "installment_rate";
            public static final String DISCOUNT_RATE = "discount_rate";
            public static final String LABELS = "labels";
            public static final String MIN_ALLOWED_AMOUNT = "min_allowed_amount";
            public static final String MAX_ALLOWED_AMOUNT = "max_allowed_amount";
            public static final String RECOMMENDED_MESSAGE = "recommended_message";
            public static final String INSTALLMENT_AMOUNT = "installment_amount";
            public static final String TOTAL_AMOUNT = "total_amount";
        }
    }
}
