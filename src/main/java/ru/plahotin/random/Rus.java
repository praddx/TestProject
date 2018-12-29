package ru.plahotin.random;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

public class Rus {
    private static Map<String, CabinType> coachTypes = new HashMap<>();
    private static Map<String, String> railClasses = new HashMap<>();
    private static Map<String, String> cyr2Lat = new HashMap<>();

    static {
        cyr2Lat.put("1" + Character.valueOf('\u0410'), RailFareCode.A1.getCode());
        cyr2Lat.put("1" + Character.valueOf('\u0411'), RailFareCode.B1.getCode());
        cyr2Lat.put("1" + Character.valueOf('\u0412'), RailFareCode.V1.getCode());
        cyr2Lat.put("1" + Character.valueOf('\u0413'), RailFareCode.G1.getCode());
        cyr2Lat.put("1" + Character.valueOf('\u0414'), RailFareCode.D1.getCode());
        cyr2Lat.put("1" + Character.valueOf('\u0415'), RailFareCode.E1.getCode());
        cyr2Lat.put("1" + Character.valueOf('\u0418'), RailFareCode.I1.getCode());
        cyr2Lat.put("1" + Character.valueOf('\u041B'), RailFareCode.L1.getCode());
        cyr2Lat.put("1" + Character.valueOf('\u041C'), RailFareCode.M1.getCode());
        cyr2Lat.put("1" + Character.valueOf('\u041D'), RailFareCode.N1.getCode());
        cyr2Lat.put("1" + Character.valueOf('\u0420'), RailFareCode.R1.getCode());
        cyr2Lat.put("1" + Character.valueOf('\u0421'), RailFareCode.S1.getCode());
        cyr2Lat.put("1" + Character.valueOf('\u0423'), RailFareCode.U1.getCode());
        cyr2Lat.put("1" + Character.valueOf('\u042D'), RailFareCode.Y1.getCode());
        cyr2Lat.put("2" + Character.valueOf('\u0411'), RailFareCode.B2.getCode());
        cyr2Lat.put("2" + Character.valueOf('\u0412'), RailFareCode.V2.getCode());
        cyr2Lat.put("2" + Character.valueOf('\u0414'), RailFareCode.D2.getCode());
        cyr2Lat.put("2" + Character.valueOf('\u0415'), RailFareCode.E2.getCode());
        cyr2Lat.put("2" + Character.valueOf('\u0418'), RailFareCode.I2.getCode());
        cyr2Lat.put("2" + Character.valueOf('\u041A'), RailFareCode.K2.getCode());
        cyr2Lat.put("2" + Character.valueOf('\u041B'), RailFareCode.L2.getCode());
        cyr2Lat.put("2" + Character.valueOf('\u041C'), RailFareCode.M2.getCode());
        cyr2Lat.put("2" + Character.valueOf('\u0420'), RailFareCode.R2.getCode());
        cyr2Lat.put("2" + Character.valueOf('\u0421'), RailFareCode.S2.getCode());
        cyr2Lat.put("2" + Character.valueOf('\u0422'), RailFareCode.T2.getCode());
        cyr2Lat.put("2" + Character.valueOf('\u0423'), RailFareCode.U2.getCode());
        cyr2Lat.put("2" + Character.valueOf('\u042D'), RailFareCode.Y2.getCode());
        cyr2Lat.put("3" + Character.valueOf('\u0412'), RailFareCode.V3.getCode());
        cyr2Lat.put("3" + Character.valueOf('\u0414'), RailFareCode.D3.getCode());
        cyr2Lat.put("3" + Character.valueOf('\u0416'), RailFareCode.Z3.getCode());
        cyr2Lat.put("3" + Character.valueOf('\u041B'), RailFareCode.L3.getCode());
        cyr2Lat.put("3" + Character.valueOf('\u041E'), RailFareCode.O3.getCode());
        cyr2Lat.put("3" + Character.valueOf('\u041F'), RailFareCode.P3.getCode());
        cyr2Lat.put("3" + Character.valueOf('\u0420'), RailFareCode.R3.getCode());
        cyr2Lat.put("3" + Character.valueOf('\u0421'), RailFareCode.S3.getCode());
        cyr2Lat.put("3" + Character.valueOf('\u0422'), RailFareCode.T3.getCode());
        cyr2Lat.put("3" + Character.valueOf('\u0423'), RailFareCode.U3.getCode());
        cyr2Lat.put("3" + Character.valueOf('\u042D'), RailFareCode.Y3.getCode());

        railClasses.put(RailFareCode.A1.getCode(), "First class");
        railClasses.put(RailFareCode.B1.getCode(), "First class");
        railClasses.put(RailFareCode.V1.getCode(), "First class");
        railClasses.put(RailFareCode.G1.getCode(), "First class");
        railClasses.put(RailFareCode.D1.getCode(), "First class");
        railClasses.put(RailFareCode.E1.getCode(), "First class");
        railClasses.put(RailFareCode.I1.getCode(), "First class");
        railClasses.put(RailFareCode.L1.getCode(), "First class");
        railClasses.put(RailFareCode.M1.getCode(), "First class");
        railClasses.put(RailFareCode.N1.getCode(), "First class");
        railClasses.put(RailFareCode.R1.getCode(), "First class");
        railClasses.put(RailFareCode.S1.getCode(), "First class");
        railClasses.put(RailFareCode.U1.getCode(), "First class");
        railClasses.put(RailFareCode.Y1.getCode(), "First class");
        railClasses.put(RailFareCode.B2.getCode(), "Second class");
        railClasses.put(RailFareCode.V2.getCode(), "Second class");
        railClasses.put(RailFareCode.D2.getCode(), "Third class");
        railClasses.put(RailFareCode.E2.getCode(), "Second class");
        railClasses.put(RailFareCode.I2.getCode(), "Second class");
        railClasses.put(RailFareCode.K2.getCode(), "Second class");
        railClasses.put(RailFareCode.L2.getCode(), "Second class");
        railClasses.put(RailFareCode.M2.getCode(), "Second class");
        railClasses.put(RailFareCode.R2.getCode(), "Second class");
        railClasses.put(RailFareCode.S2.getCode(), "Second class");
        railClasses.put(RailFareCode.T2.getCode(), "Second class");
        railClasses.put(RailFareCode.U2.getCode(), "Second class");
        railClasses.put(RailFareCode.Y2.getCode(), "Second class");
        railClasses.put(RailFareCode.V3.getCode(), "Third class");
        railClasses.put(RailFareCode.D3.getCode(), "Third class");
        railClasses.put(RailFareCode.Z3.getCode(), "Third class");
        railClasses.put(RailFareCode.L3.getCode(), "Third class");
        railClasses.put(RailFareCode.O3.getCode(), "Third class");
        railClasses.put(RailFareCode.P3.getCode(), "Third class");
        railClasses.put(RailFareCode.R3.getCode(), "Third class");
        railClasses.put(RailFareCode.S3.getCode(), "Third class");
        railClasses.put(RailFareCode.T3.getCode(), "Third class");
        railClasses.put(RailFareCode.U3.getCode(), "Third class");
        railClasses.put(RailFareCode.Y3.getCode(), "Third class");

        coachTypes.put(RailFareCode.A1.getCode(), CabinType.M);
        coachTypes.put(RailFareCode.B1.getCode(), CabinType.L);
        coachTypes.put(RailFareCode.V1.getCode(), CabinType.S);
        coachTypes.put(RailFareCode.G1.getCode(), CabinType.M);
        coachTypes.put(RailFareCode.D1.getCode(), CabinType.L);
        coachTypes.put(RailFareCode.E1.getCode(), CabinType.L);
        coachTypes.put(RailFareCode.I1.getCode(), CabinType.M);
        coachTypes.put(RailFareCode.L1.getCode(), CabinType.L);
        coachTypes.put(RailFareCode.M1.getCode(), CabinType.M);
        coachTypes.put(RailFareCode.N1.getCode(), CabinType.M);
        coachTypes.put(RailFareCode.R1.getCode(), CabinType.S);
        coachTypes.put(RailFareCode.S1.getCode(), CabinType.S);
        coachTypes.put(RailFareCode.U1.getCode(), CabinType.L);
        coachTypes.put(RailFareCode.Y1.getCode(), CabinType.L);
        coachTypes.put(RailFareCode.B2.getCode(), CabinType.K);
        coachTypes.put(RailFareCode.V2.getCode(), CabinType.S);
        coachTypes.put(RailFareCode.D2.getCode(), CabinType.K);
        coachTypes.put(RailFareCode.E2.getCode(), CabinType.S);
        coachTypes.put(RailFareCode.I2.getCode(), CabinType.K);
        coachTypes.put(RailFareCode.K2.getCode(), CabinType.K);
        coachTypes.put(RailFareCode.L2.getCode(), CabinType.K);
        coachTypes.put(RailFareCode.M2.getCode(), CabinType.S);
        coachTypes.put(RailFareCode.R2.getCode(), CabinType.S);
        coachTypes.put(RailFareCode.S2.getCode(), CabinType.S);
        coachTypes.put(RailFareCode.T2.getCode(), CabinType.K);
        coachTypes.put(RailFareCode.U2.getCode(), CabinType.K);
        coachTypes.put(RailFareCode.Y2.getCode(), CabinType.K);
        coachTypes.put(RailFareCode.V3.getCode(), CabinType.O);
        coachTypes.put(RailFareCode.D3.getCode(), CabinType.P);
        coachTypes.put(RailFareCode.Z3.getCode(), CabinType.S);
        coachTypes.put(RailFareCode.L3.getCode(), CabinType.P);
        coachTypes.put(RailFareCode.O3.getCode(), CabinType.O);
        coachTypes.put(RailFareCode.P3.getCode(), CabinType.P);
        coachTypes.put(RailFareCode.R3.getCode(), CabinType.O);
        coachTypes.put(RailFareCode.S3.getCode(), CabinType.S);
        coachTypes.put(RailFareCode.T3.getCode(), CabinType.P);
        coachTypes.put(RailFareCode.U3.getCode(), CabinType.P);
        coachTypes.put(RailFareCode.Y3.getCode(), CabinType.P);
    }

    public static void main(String[] args) {
        cyr2Lat.entrySet().stream().forEach(e -> System.out.println(e.getKey() + " : " + e.getValue()));
    }

    enum RailFareCode {

        A1("1A"),
        B1("1B"),
        V1("1V"),
        G1("1G"),
        D1("1D"),
        E1("1E"),
        I1("1I"),
        L1("1L"),
        M1("1M"),
        N1("1N"),
        R1("1R"),
        S1("1S"),
        U1("1U"),
        Y1("1Y"),
        B2("2B"),
        V2("2V"),
        D2("2D"),
        E2("2E"),
        I2("2I"),
        K2("2K"),
        L2("2L"),
        M2("2M"),
        R2("2R"),
        S2("2S"),
        T2("2T"),
        U2("2U"),
        Y2("2Y"),
        V3("3V"),
        D3("3D"),
        Z3("3Z"),
        L3("3L"),
        O3("3O"),
        P3("3P"),
        R3("3R"),
        S3("3S"),
        T3("3T"),
        U3("3U"),
        Y3("3Y");

        private String code;

        private RailFareCode(String code) {
            this.code = code;
        }

        public String getCode() {
            return code;
        }
    }

    enum CabinType {

        K {
            @Override
            public String toString() {
                return Messages.coachType_K;
            }
        },
        L {
            @Override
            public String toString() {
                return Messages.coachType_L;
            }
        },
        M {
            @Override
            public String toString() {
                return Messages.coachType_M;
            }
        },
        O {
            @Override
            public String toString() {
                return Messages.coachType_O;
            }
        },
        P {
            @Override
            public String toString() {
                return Messages.coachType_P;
            }
        },
        S {
            @Override
            public String toString() {
                return Messages.coachType_S;
            }
        };

        public abstract String toString();

        public static CabinType lookUpValue(String value) {
            if (value == null) {
                return null;
            }
            return Stream.of(CabinType.values()).filter(v -> value.equalsIgnoreCase(v.toString()) || value.equals(v.name()))
                    .findAny().orElse(null);
        }
    }

    static class Messages {
        public static String coachType_S;
        public static String coachType_P;
        public static String coachType_M;
        public static String coachType_O;
        public static String coachType_L;
        public static String coachType_K;
    }
}
