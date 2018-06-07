package entity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


// TODO: complite the survey and create quantification class
// TODO: extrapolate values

public class Survey {
    private Map<Integer, Integer> scoringScale;

    // TODO: change to StingBuffer?
    // demographical data
    private String ageCategory;
    private String gender;
    private String education;
    private String country;
    private String ethnicity;

    // personal traits
    private int nscore;
    private int escore;
    private int oscore;
    private int ascore;
    private int cscore;
    private int impss;
    private int inpulsiveness;

    // NEO-FFI fields
    private int field;
    private int field2;
    private int field3;
    private int field4;
    private int field5;
    private int field6;
    private int field7;
    private int field8;
    private int field9;
    private int field10;
    private int field11;
    private int field12;
    private int field13;
    private int field14;
    private int field15;
    private int field16;
    private int field17;
    private int field18;
    private int field19;
    private int field20;
    private int field21;
    private int field22;
    private int field23;
    private int field24;
    private int field25;
    private int field26;
    private int field27;
    private int field28;
    private int field29;
    private int field30;
    private int field31;
    private int field32;
    private int field33;
    private int field34;
    private int field35;
    private int field36;
    private int field37;
    private int field38;
    private int field39;
    private int field40;
    private int field41;
    private int field42;
    private int field43;
    private int field44;
    private int field45;
    private int field46;
    private int field47;
    private int field48;
    private int field49;
    private int field50;
    private int field51;
    private int field52;
    private int field53;
    private int field54;
    private int field55;
    private int field56;
    private int field57;
    private int field58;
    private int field59;
    private int field60;
    private int field61;
    private int field62;
    private int field63;
    private int field64;
    private int field65;
    private int field66;
    private int field67;
    private int field68;
    private int field69;
    private int field70;
    private int field71;
    private int field72;
    private int field73;
    private int field74;
    private int field75;

    // ZKPQ fields 21-30 for ImpSS trait
    private int zkpq1;
    private int zkpq2;
    private int zkpq3;
    private int zkpq4;
    private int zkpq5;
    private int zkpq6;
    private int zkpq7;
    private int zkpq8;
    private int zkpq9;
    private int zkpq10;

    public Survey() {
        scoringScale = new HashMap<>(5);
        scoringScale.put(-2, 5);
        scoringScale.put(-1, 4);
        scoringScale.put(0, 3);
        scoringScale.put(1, 2);
        scoringScale.put(2, 1);
    }

    public void computeResults() {
        nscore = scoringScale.get(field)
                + scoringScale.get(field6)
                + scoringScale.get(field11)
                + scoringScale.get(field16)
                + scoringScale.get(field21)
                + scoringScale.get(field26)
                + scoringScale.get(field31)
                + scoringScale.get(field36)
                + scoringScale.get(field41)
                + scoringScale.get(field46)
                + scoringScale.get(field51)
                + scoringScale.get(field56)
                + scoringScale.get(field61)
                + scoringScale.get(field66)
                + scoringScale.get(field71);

        System.err.println("NSCORE: "  + nscore);

        escore = scoringScale.get(field2)
                + scoringScale.get(field7)
                + scoringScale.get(field12)
                + scoringScale.get(field17)
                + scoringScale.get(field22)
                + scoringScale.get(field27)
                + scoringScale.get(field32)
                + scoringScale.get(field37)
                + scoringScale.get(field42)
                + scoringScale.get(field47)
                + scoringScale.get(field52)
                + scoringScale.get(field57)
                + scoringScale.get(field62)
                + scoringScale.get(field67)
                + scoringScale.get(field72);

        System.err.println("ESCORE: " + escore);

        oscore = scoringScale.get(field3)
                + scoringScale.get(field8)
                + scoringScale.get(field13)
                + scoringScale.get(field18)
                + scoringScale.get(field23)
                + scoringScale.get(field28)
                + scoringScale.get(field33)
                + scoringScale.get(field38)
                + scoringScale.get(field43)
                + scoringScale.get(field48)
                + scoringScale.get(field53)
                + scoringScale.get(field58)
                + scoringScale.get(field63)
                + scoringScale.get(field68)
                + scoringScale.get(field73);

        System.err.println("OSCORE: " + oscore);

        ascore = scoringScale.get(field4)
                + scoringScale.get(field9)
                + scoringScale.get(field14)
                + scoringScale.get(field19)
                + scoringScale.get(field24)
                + scoringScale.get(field29)
                + scoringScale.get(field34)
                + scoringScale.get(field39)
                + scoringScale.get(field44)
                + scoringScale.get(field49)
                + scoringScale.get(field54)
                + scoringScale.get(field59)
                + scoringScale.get(field64)
                + scoringScale.get(field69)
                + scoringScale.get(field74);

        cscore = scoringScale.get(field5)
                + scoringScale.get(field10)
                + scoringScale.get(field15)
                + scoringScale.get(field20)
                + scoringScale.get(field25)
                + scoringScale.get(field30)
                + scoringScale.get(field35)
                + scoringScale.get(field40)
                + scoringScale.get(field45)
                + scoringScale.get(field50)
                + scoringScale.get(field55)
                + scoringScale.get(field60)
                + scoringScale.get(field65)
                + scoringScale.get(field70)
                + scoringScale.get(field75);
    }

    public Map<Integer, Integer> getScoringScale() {
        return scoringScale;
    }

    public void setScoringScale(Map<Integer, Integer> scoringScale) {
        this.scoringScale = scoringScale;
    }

    public String getAgeCategory() {
        return ageCategory;
    }

    public void setAgeCategory(String ageCategory) {
        this.ageCategory = ageCategory;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getEthnicity() {
        return ethnicity;
    }

    public void setEthnicity(String ethnicity) {
        this.ethnicity = ethnicity;
    }

    public int getNscore() {
        return nscore;
    }

    public void setNscore(int nscore) {
        this.nscore = nscore;
    }

    public int getEscore() {
        return escore;
    }

    public void setEscore(int escore) {
        this.escore = escore;
    }

    public int getOscore() {
        return oscore;
    }

    public void setOscore(int oscore) {
        this.oscore = oscore;
    }

    public int getAscore() {
        return ascore;
    }

    public void setAscore(int ascore) {
        this.ascore = ascore;
    }

    public int getCscore() {
        return cscore;
    }

    public void setCscore(int cscore) {
        this.cscore = cscore;
    }

    public int getImpss() {
        return impss;
    }

    public void setImpss(int impss) {
        this.impss = impss;
    }

    public int getInpulsiveness() {
        return inpulsiveness;
    }

    public void setInpulsiveness(int inpulsiveness) {
        this.inpulsiveness = inpulsiveness;
    }

    public int getField() {
        return field;
    }

    public void setField(int field) {
        this.field = field;
    }

    public int getField2() {
        return field2;
    }

    public void setField2(int field2) {
        this.field2 = field2;
    }

    public int getField3() {
        return field3;
    }

    public void setField3(int field3) {
        this.field3 = field3;
    }

    public int getField4() {
        return field4;
    }

    public void setField4(int field4) {
        this.field4 = field4;
    }

    public int getField5() {
        return field5;
    }

    public void setField5(int field5) {
        this.field5 = field5;
    }

    public int getField6() {
        return field6;
    }

    public void setField6(int field6) {
        this.field6 = field6;
    }

    public int getField7() {
        return field7;
    }

    public void setField7(int field7) {
        this.field7 = field7;
    }

    public int getField8() {
        return field8;
    }

    public void setField8(int field8) {
        this.field8 = field8;
    }

    public int getField9() {
        return field9;
    }

    public void setField9(int field9) {
        this.field9 = field9;
    }

    public int getField10() {
        return field10;
    }

    public void setField10(int field10) {
        this.field10 = field10;
    }

    public int getField11() {
        return field11;
    }

    public void setField11(int field11) {
        this.field11 = field11;
    }

    public int getField12() {
        return field12;
    }

    public void setField12(int field12) {
        this.field12 = field12;
    }

    public int getField13() {
        return field13;
    }

    public void setField13(int field13) {
        this.field13 = field13;
    }

    public int getField14() {
        return field14;
    }

    public void setField14(int field14) {
        this.field14 = field14;
    }

    public int getField15() {
        return field15;
    }

    public void setField15(int field15) {
        this.field15 = field15;
    }

    public int getField16() {
        return field16;
    }

    public void setField16(int field16) {
        this.field16 = field16;
    }

    public int getField17() {
        return field17;
    }

    public void setField17(int field17) {
        this.field17 = field17;
    }

    public int getField18() {
        return field18;
    }

    public void setField18(int field18) {
        this.field18 = field18;
    }

    public int getField19() {
        return field19;
    }

    public void setField19(int field19) {
        this.field19 = field19;
    }

    public int getField20() {
        return field20;
    }

    public void setField20(int field20) {
        this.field20 = field20;
    }

    public int getField21() {
        return field21;
    }

    public void setField21(int field21) {
        this.field21 = field21;
    }

    public int getField22() {
        return field22;
    }

    public void setField22(int field22) {
        this.field22 = field22;
    }

    public int getField23() {
        return field23;
    }

    public void setField23(int field23) {
        this.field23 = field23;
    }

    public int getField24() {
        return field24;
    }

    public void setField24(int field24) {
        this.field24 = field24;
    }

    public int getField25() {
        return field25;
    }

    public void setField25(int field25) {
        this.field25 = field25;
    }

    public int getField26() {
        return field26;
    }

    public void setField26(int field26) {
        this.field26 = field26;
    }

    public int getField27() {
        return field27;
    }

    public void setField27(int field27) {
        this.field27 = field27;
    }

    public int getField28() {
        return field28;
    }

    public void setField28(int field28) {
        this.field28 = field28;
    }

    public int getField29() {
        return field29;
    }

    public void setField29(int field29) {
        this.field29 = field29;
    }

    public int getField30() {
        return field30;
    }

    public void setField30(int field30) {
        this.field30 = field30;
    }

    public int getField31() {
        return field31;
    }

    public void setField31(int field31) {
        this.field31 = field31;
    }

    public int getField32() {
        return field32;
    }

    public void setField32(int field32) {
        this.field32 = field32;
    }

    public int getField33() {
        return field33;
    }

    public void setField33(int field33) {
        this.field33 = field33;
    }

    public int getField34() {
        return field34;
    }

    public void setField34(int field34) {
        this.field34 = field34;
    }

    public int getField35() {
        return field35;
    }

    public void setField35(int field35) {
        this.field35 = field35;
    }

    public int getField36() {
        return field36;
    }

    public void setField36(int field36) {
        this.field36 = field36;
    }

    public int getField37() {
        return field37;
    }

    public void setField37(int field37) {
        this.field37 = field37;
    }

    public int getField38() {
        return field38;
    }

    public void setField38(int field38) {
        this.field38 = field38;
    }

    public int getField39() {
        return field39;
    }

    public void setField39(int field39) {
        this.field39 = field39;
    }

    public int getField40() {
        return field40;
    }

    public void setField40(int field40) {
        this.field40 = field40;
    }

    public int getField41() {
        return field41;
    }

    public void setField41(int field41) {
        this.field41 = field41;
    }

    public int getField42() {
        return field42;
    }

    public void setField42(int field42) {
        this.field42 = field42;
    }

    public int getField43() {
        return field43;
    }

    public void setField43(int field43) {
        this.field43 = field43;
    }

    public int getField44() {
        return field44;
    }

    public void setField44(int field44) {
        this.field44 = field44;
    }

    public int getField45() {
        return field45;
    }

    public void setField45(int field45) {
        this.field45 = field45;
    }

    public int getField46() {
        return field46;
    }

    public void setField46(int field46) {
        this.field46 = field46;
    }

    public int getField47() {
        return field47;
    }

    public void setField47(int field47) {
        this.field47 = field47;
    }

    public int getField48() {
        return field48;
    }

    public void setField48(int field48) {
        this.field48 = field48;
    }

    public int getField49() {
        return field49;
    }

    public void setField49(int field49) {
        this.field49 = field49;
    }

    public int getField50() {
        return field50;
    }

    public void setField50(int field50) {
        this.field50 = field50;
    }

    public int getField51() {
        return field51;
    }

    public void setField51(int field51) {
        this.field51 = field51;
    }

    public int getField52() {
        return field52;
    }

    public void setField52(int field52) {
        this.field52 = field52;
    }

    public int getField53() {
        return field53;
    }

    public void setField53(int field53) {
        this.field53 = field53;
    }

    public int getField54() {
        return field54;
    }

    public void setField54(int field54) {
        this.field54 = field54;
    }

    public int getField55() {
        return field55;
    }

    public void setField55(int field55) {
        this.field55 = field55;
    }

    public int getField56() {
        return field56;
    }

    public void setField56(int field56) {
        this.field56 = field56;
    }

    public int getField57() {
        return field57;
    }

    public void setField57(int field57) {
        this.field57 = field57;
    }

    public int getField58() {
        return field58;
    }

    public void setField58(int field58) {
        this.field58 = field58;
    }

    public int getField59() {
        return field59;
    }

    public void setField59(int field59) {
        this.field59 = field59;
    }

    public int getField60() {
        return field60;
    }

    public void setField60(int field60) {
        this.field60 = field60;
    }

    public int getField61() {
        return field61;
    }

    public void setField61(int field61) {
        this.field61 = field61;
    }

    public int getField62() {
        return field62;
    }

    public void setField62(int field62) {
        this.field62 = field62;
    }

    public int getField63() {
        return field63;
    }

    public void setField63(int field63) {
        this.field63 = field63;
    }

    public int getField64() {
        return field64;
    }

    public void setField64(int field64) {
        this.field64 = field64;
    }

    public int getField65() {
        return field65;
    }

    public void setField65(int field65) {
        this.field65 = field65;
    }

    public int getField66() {
        return field66;
    }

    public void setField66(int field66) {
        this.field66 = field66;
    }

    public int getField67() {
        return field67;
    }

    public void setField67(int field67) {
        this.field67 = field67;
    }

    public int getField68() {
        return field68;
    }

    public void setField68(int field68) {
        this.field68 = field68;
    }

    public int getField69() {
        return field69;
    }

    public void setField69(int field69) {
        this.field69 = field69;
    }

    public int getField70() {
        return field70;
    }

    public void setField70(int field70) {
        this.field70 = field70;
    }

    public int getField71() {
        return field71;
    }

    public void setField71(int field71) {
        this.field71 = field71;
    }

    public int getField72() {
        return field72;
    }

    public void setField72(int field72) {
        this.field72 = field72;
    }

    public int getField73() {
        return field73;
    }

    public void setField73(int field73) {
        this.field73 = field73;
    }

    public int getField74() {
        return field74;
    }

    public void setField74(int field74) {
        this.field74 = field74;
    }

    public int getField75() {
        return field75;
    }

    public void setField75(int field75) {
        this.field75 = field75;
    }

    public int getZkpq1() {
        return zkpq1;
    }

    public void setZkpq1(int zkpq1) {
        this.zkpq1 = zkpq1;
    }

    public int getZkpq2() {
        return zkpq2;
    }

    public void setZkpq2(int zkpq2) {
        this.zkpq2 = zkpq2;
    }

    public int getZkpq3() {
        return zkpq3;
    }

    public void setZkpq3(int zkpq3) {
        this.zkpq3 = zkpq3;
    }

    public int getZkpq4() {
        return zkpq4;
    }

    public void setZkpq4(int zkpq4) {
        this.zkpq4 = zkpq4;
    }

    public int getZkpq5() {
        return zkpq5;
    }

    public void setZkpq5(int zkpq5) {
        this.zkpq5 = zkpq5;
    }

    public int getZkpq6() {
        return zkpq6;
    }

    public void setZkpq6(int zkpq6) {
        this.zkpq6 = zkpq6;
    }

    public int getZkpq7() {
        return zkpq7;
    }

    public void setZkpq7(int zkpq7) {
        this.zkpq7 = zkpq7;
    }

    public int getZkpq8() {
        return zkpq8;
    }

    public void setZkpq8(int zkpq8) {
        this.zkpq8 = zkpq8;
    }

    public int getZkpq9() {
        return zkpq9;
    }

    public void setZkpq9(int zkpq9) {
        this.zkpq9 = zkpq9;
    }

    public int getZkpq10() {
        return zkpq10;
    }

    public void setZkpq10(int zkpq10) {
        this.zkpq10 = zkpq10;
    }
}