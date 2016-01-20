package org.docksidestage.hangar.freeflute.web;

import java.util.*;

import org.dbflute.jdbc.Classification;
import org.dbflute.jdbc.ClassificationCodeType;
import org.dbflute.jdbc.ClassificationMeta;
import org.dbflute.jdbc.ClassificationUndefinedHandlingType;
import org.dbflute.optional.OptionalThing;
import org.docksidestage.hangar.dbflute.allcommon.*;

/**
 * The definition of web classification.
 * @author FreeGen
 */
public interface WebCDef extends Classification {

    /** The empty array for no sisters. */
    String[] EMPTY_SISTERS = new String[]{};

    /** The empty map for no sub-items. */
    @SuppressWarnings("unchecked")
    Map<String, Object> EMPTY_SUB_ITEM_MAP = (Map<String, Object>)Collections.EMPTY_MAP;

    /**
     * Sea Cls
     */
    public enum WebSea implements WebCDef {
        /** Formalized: as formal member, allowed to use all service */
        Formalized("FML", "Formalized", EMPTY_SISTERS)
        ,
        /** Withdrawal: withdrawal is fixed, not allowed to use service */
        Withdrawal("WDL", "Withdrawal", EMPTY_SISTERS)
        ,
        /** Provisional: first status after entry, allowed to use only part of service */
        Provisional("PRV", "Provisional", EMPTY_SISTERS)
        ;
        private static final Map<String, WebSea> _codeValueMap = new HashMap<String, WebSea>();
        static {
            for (WebSea value : values()) {
                _codeValueMap.put(value.code().toLowerCase(), value);
                for (String sister : value.sisterSet()) { _codeValueMap.put(sister.toLowerCase(), value); }
            }
        }
        private static final Map<String, Map<String, Object>> _subItemMapMap = new HashMap<String, Map<String, Object>>();
        static {
            {
                Map<String, Object> subItemMap = new HashMap<String, Object>();
                subItemMap.put("key1", "1");
                subItemMap.put("key2", "as formal member, allowed to use all service");
                _subItemMapMap.put(Formalized.code(), Collections.unmodifiableMap(subItemMap));
            }
            {
                Map<String, Object> subItemMap = new HashMap<String, Object>();
                subItemMap.put("key1", "2");
                subItemMap.put("key2", "withdrawal is fixed, not allowed to use service");
                _subItemMapMap.put(Withdrawal.code(), Collections.unmodifiableMap(subItemMap));
            }
            {
                Map<String, Object> subItemMap = new HashMap<String, Object>();
                subItemMap.put("key1", "3");
                subItemMap.put("key2", "first status after entry, allowed to use only part of service");
                _subItemMapMap.put(Provisional.code(), Collections.unmodifiableMap(subItemMap));
            }
        }
        private String _code; private String _alias; private Set<String> _sisterSet;
        private WebSea(String code, String alias, String[] sisters)
        { _code = code; _alias = alias; _sisterSet = Collections.unmodifiableSet(new LinkedHashSet<String>(Arrays.asList(sisters))); }
        public String code() { return _code; } public String alias() { return _alias; }
        public Set<String> sisterSet() { return _sisterSet; }
        public Map<String, Object> subItemMap() { return _subItemMapMap.get(code()); }
        public ClassificationMeta meta() { return WebCDef.DefMeta.WebSea; }

        public String key1() {
            return (String)subItemMap().get("key1");
        }

        public String key2() {
            return (String)subItemMap().get("key2");
        }

        public boolean inGroup(String groupName) {
            return false;
        }

        /**
         * Get the classification by the code. (CaseInsensitive)
         * @param code The value of code, which is case-insensitive. (NullAllowed: if null, returns null)
         * @return The instance of the corresponding classification to the code. (NullAllowed: if not found, returns null)
         */
        public static WebSea codeOf(Object code) {
            if (code == null) { return null; }
            if (code instanceof WebSea) { return (WebSea)code; }
            return _codeValueMap.get(code.toString().toLowerCase());
        }

        /**
         * Get the classification by the name (also called 'value' in ENUM world).
         * @param name The string of name, which is case-sensitive. (NullAllowed: if null, returns null)
         * @return The instance of the corresponding classification to the name. (NullAllowed: if not found, returns null)
         */
        public static WebSea nameOf(String name) {
            if (name == null) { return null; }
            try { return valueOf(name); } catch (RuntimeException ignored) { return null; }
        }

        /**
         * Get the list of all classification elements. (returns new copied list)
         * @return The snapshot list of all classification elements. (NotNull)
         */
        public static List<WebSea> listAll() {
            return new ArrayList<WebSea>(Arrays.asList(values()));
        }

        /**
         * Get the list of classification elements in the specified group. (returns new copied list) <br>
         * @param groupName The string of group name, which is case-sensitive. (NullAllowed: if null, returns empty list)
         * @return The snapshot list of classification elements in the group. (NotNull, EmptyAllowed: if the group is not found)
         */
        public static List<WebSea> groupOf(String groupName) {
            return new ArrayList<WebSea>(4);
        }

        /**
         * @param dbCls The DB classification to find. (NullAllowed: if null, returns empty) 
         * @return The the web classification corresponding to the DB classification. (NotNull, EmptyAllowed: when null specified, not found)
         */
        public static OptionalThing<WebSea> fromDBCls(CDef.MemberStatus dbCls) {
            String dbCode = dbCls != null ? dbCls.code() : null;
            return OptionalThing.ofNullable(codeOf(dbCode), () -> {
                throw new IllegalStateException("Cannot convert CDef.MemberStatus to WebSea by the DB code: " + dbCode);
            });
        }

        /**
         * @return The DB classification corresponding to the web classification. (NotNull, EmptyAllowed: when no-related to DB)
         */
        public OptionalThing<CDef.MemberStatus> toDBCls() {
            String webCode = code();
            return OptionalThing.ofNullable(CDef.MemberStatus.codeOf(webCode), () -> {
                throw new IllegalStateException("Cannot convert WebSea to MemberStatus by the web code: " + webCode);
            });
        }

        @Override public String toString() { return code(); }
    }

    /**
     * Land Cls
     */
    public enum WebLand implements WebCDef {
        /** ShowBase: Formalized */
        OneMan("FML", "ShowBase", EMPTY_SISTERS)
        ,
        /** Orlean: Withdrawal */
        MiniO("WDL", "Orlean", EMPTY_SISTERS)
        ;
        private static final Map<String, WebLand> _codeValueMap = new HashMap<String, WebLand>();
        static {
            for (WebLand value : values()) {
                _codeValueMap.put(value.code().toLowerCase(), value);
                for (String sister : value.sisterSet()) { _codeValueMap.put(sister.toLowerCase(), value); }
            }
        }
        private String _code; private String _alias; private Set<String> _sisterSet;
        private WebLand(String code, String alias, String[] sisters)
        { _code = code; _alias = alias; _sisterSet = Collections.unmodifiableSet(new LinkedHashSet<String>(Arrays.asList(sisters))); }
        public String code() { return _code; } public String alias() { return _alias; }
        public Set<String> sisterSet() { return _sisterSet; }
        public Map<String, Object> subItemMap() { return EMPTY_SUB_ITEM_MAP; }
        public ClassificationMeta meta() { return WebCDef.DefMeta.WebLand; }

        public boolean inGroup(String groupName) {
            return false;
        }

        /**
         * Get the classification by the code. (CaseInsensitive)
         * @param code The value of code, which is case-insensitive. (NullAllowed: if null, returns null)
         * @return The instance of the corresponding classification to the code. (NullAllowed: if not found, returns null)
         */
        public static WebLand codeOf(Object code) {
            if (code == null) { return null; }
            if (code instanceof WebLand) { return (WebLand)code; }
            return _codeValueMap.get(code.toString().toLowerCase());
        }

        /**
         * Get the classification by the name (also called 'value' in ENUM world).
         * @param name The string of name, which is case-sensitive. (NullAllowed: if null, returns null)
         * @return The instance of the corresponding classification to the name. (NullAllowed: if not found, returns null)
         */
        public static WebLand nameOf(String name) {
            if (name == null) { return null; }
            try { return valueOf(name); } catch (RuntimeException ignored) { return null; }
        }

        /**
         * Get the list of all classification elements. (returns new copied list)
         * @return The snapshot list of all classification elements. (NotNull)
         */
        public static List<WebLand> listAll() {
            return new ArrayList<WebLand>(Arrays.asList(values()));
        }

        /**
         * Get the list of classification elements in the specified group. (returns new copied list) <br>
         * @param groupName The string of group name, which is case-sensitive. (NullAllowed: if null, returns empty list)
         * @return The snapshot list of classification elements in the group. (NotNull, EmptyAllowed: if the group is not found)
         */
        public static List<WebLand> groupOf(String groupName) {
            return new ArrayList<WebLand>(4);
        }

        /**
         * @param dbCls The DB classification to find. (NullAllowed: if null, returns empty) 
         * @return The the web classification corresponding to the DB classification. (NotNull, EmptyAllowed: when null specified, not found)
         */
        public static OptionalThing<WebLand> fromDBCls(CDef.MemberStatus dbCls) {
            String dbCode = dbCls != null ? dbCls.code() : null;
            return OptionalThing.ofNullable(codeOf(dbCode), () -> {
                throw new IllegalStateException("Cannot convert CDef.MemberStatus to WebLand by the DB code: " + dbCode);
            });
        }

        /**
         * @return The DB classification corresponding to the web classification. (NotNull, EmptyAllowed: when no-related to DB)
         */
        public OptionalThing<CDef.MemberStatus> toDBCls() {
            String webCode = code();
            return OptionalThing.ofNullable(CDef.MemberStatus.codeOf(webCode), () -> {
                throw new IllegalStateException("Cannot convert WebLand to MemberStatus by the web code: " + webCode);
            });
        }

        @Override public String toString() { return code(); }
    }

    /**
     * Piari Cls
     */
    public enum WebPiari implements WebCDef {
        /** ShowBase: Formalized */
        OneMan("FML", "ShowBase", EMPTY_SISTERS)
        ,
        /** Dstore: Provisional */
        Dstore("PRV", "Dstore", EMPTY_SISTERS)
        ,
        /** Orlean: Withdrawal */
        MiniO("WDL", "Orlean", EMPTY_SISTERS)
        ;
        private static final Map<String, WebPiari> _codeValueMap = new HashMap<String, WebPiari>();
        static {
            for (WebPiari value : values()) {
                _codeValueMap.put(value.code().toLowerCase(), value);
                for (String sister : value.sisterSet()) { _codeValueMap.put(sister.toLowerCase(), value); }
            }
        }
        private String _code; private String _alias; private Set<String> _sisterSet;
        private WebPiari(String code, String alias, String[] sisters)
        { _code = code; _alias = alias; _sisterSet = Collections.unmodifiableSet(new LinkedHashSet<String>(Arrays.asList(sisters))); }
        public String code() { return _code; } public String alias() { return _alias; }
        public Set<String> sisterSet() { return _sisterSet; }
        public Map<String, Object> subItemMap() { return EMPTY_SUB_ITEM_MAP; }
        public ClassificationMeta meta() { return WebCDef.DefMeta.WebPiari; }

        public boolean inGroup(String groupName) {
            return false;
        }

        /**
         * Get the classification by the code. (CaseInsensitive)
         * @param code The value of code, which is case-insensitive. (NullAllowed: if null, returns null)
         * @return The instance of the corresponding classification to the code. (NullAllowed: if not found, returns null)
         */
        public static WebPiari codeOf(Object code) {
            if (code == null) { return null; }
            if (code instanceof WebPiari) { return (WebPiari)code; }
            return _codeValueMap.get(code.toString().toLowerCase());
        }

        /**
         * Get the classification by the name (also called 'value' in ENUM world).
         * @param name The string of name, which is case-sensitive. (NullAllowed: if null, returns null)
         * @return The instance of the corresponding classification to the name. (NullAllowed: if not found, returns null)
         */
        public static WebPiari nameOf(String name) {
            if (name == null) { return null; }
            try { return valueOf(name); } catch (RuntimeException ignored) { return null; }
        }

        /**
         * Get the list of all classification elements. (returns new copied list)
         * @return The snapshot list of all classification elements. (NotNull)
         */
        public static List<WebPiari> listAll() {
            return new ArrayList<WebPiari>(Arrays.asList(values()));
        }

        /**
         * Get the list of classification elements in the specified group. (returns new copied list) <br>
         * @param groupName The string of group name, which is case-sensitive. (NullAllowed: if null, returns empty list)
         * @return The snapshot list of classification elements in the group. (NotNull, EmptyAllowed: if the group is not found)
         */
        public static List<WebPiari> groupOf(String groupName) {
            return new ArrayList<WebPiari>(4);
        }

        /**
         * @param dbCls The DB classification to find. (NullAllowed: if null, returns empty) 
         * @return The the web classification corresponding to the DB classification. (NotNull, EmptyAllowed: when null specified, not found)
         */
        public static OptionalThing<WebPiari> fromDBCls(CDef.MemberStatus dbCls) {
            String dbCode = dbCls != null ? dbCls.code() : null;
            return OptionalThing.ofNullable(codeOf(dbCode), () -> {
                throw new IllegalStateException("Cannot convert CDef.MemberStatus to WebPiari by the DB code: " + dbCode);
            });
        }

        /**
         * @return The DB classification corresponding to the web classification. (NotNull, EmptyAllowed: when no-related to DB)
         */
        public OptionalThing<CDef.MemberStatus> toDBCls() {
            String webCode = code();
            return OptionalThing.ofNullable(CDef.MemberStatus.codeOf(webCode), () -> {
                throw new IllegalStateException("Cannot convert WebPiari to MemberStatus by the web code: " + webCode);
            });
        }

        @Override public String toString() { return code(); }
    }

    public enum DefMeta implements ClassificationMeta {
        /** Sea Cls */
        WebSea
        ,
        /** Land Cls */
        WebLand
        ,
        /** Piari Cls */
        WebPiari
        ;
        public String classificationName() {
            return name(); // same as definition name
        }

        public Classification codeOf(Object code) {
            if ("WebSea".equals(name())) { return WebCDef.WebSea.codeOf(code); }
            if ("WebLand".equals(name())) { return WebCDef.WebLand.codeOf(code); }
            if ("WebPiari".equals(name())) { return WebCDef.WebPiari.codeOf(code); }
            throw new IllegalStateException("Unknown definition: " + this); // basically unreachable
        }

        public Classification nameOf(String name) {
            if ("WebSea".equals(name())) { return WebCDef.WebSea.valueOf(name); }
            if ("WebLand".equals(name())) { return WebCDef.WebLand.valueOf(name); }
            if ("WebPiari".equals(name())) { return WebCDef.WebPiari.valueOf(name); }
            throw new IllegalStateException("Unknown definition: " + this); // basically unreachable
        }

        public List<Classification> listAll() {
            if ("WebSea".equals(name())) { return toClassificationList(WebCDef.WebSea.listAll()); }
            if ("WebLand".equals(name())) { return toClassificationList(WebCDef.WebLand.listAll()); }
            if ("WebPiari".equals(name())) { return toClassificationList(WebCDef.WebPiari.listAll()); }
            throw new IllegalStateException("Unknown definition: " + this); // basically unreachable
        }

        public List<Classification> groupOf(String groupName) {
            if ("WebSea".equals(name())) { return toClassificationList(WebCDef.WebSea.groupOf(groupName)); }
            if ("WebLand".equals(name())) { return toClassificationList(WebCDef.WebLand.groupOf(groupName)); }
            if ("WebPiari".equals(name())) { return toClassificationList(WebCDef.WebPiari.groupOf(groupName)); }
            throw new IllegalStateException("Unknown definition: " + this); // basically unreachable
        }

        @SuppressWarnings("unchecked")
        private List<Classification> toClassificationList(List<?> clsList) {
            return (List<Classification>)clsList;
        }

        public ClassificationCodeType codeType() {
            if ("WebSea".equals(name())) { return ClassificationCodeType.String; }
            if ("WebLand".equals(name())) { return ClassificationCodeType.String; }
            if ("WebPiari".equals(name())) { return ClassificationCodeType.String; }
            return ClassificationCodeType.String; // as default
        }

        public ClassificationUndefinedHandlingType undefinedHandlingType() {
            if ("WebSea".equals(name())) { return ClassificationUndefinedHandlingType.LOGGING; }
            if ("WebLand".equals(name())) { return ClassificationUndefinedHandlingType.LOGGING; }
            if ("WebPiari".equals(name())) { return ClassificationUndefinedHandlingType.LOGGING; }
            return ClassificationUndefinedHandlingType.LOGGING; // as default
        }

        public static WebCDef.DefMeta meta(String classificationName) { // instead of valueOf()
            if (classificationName == null) { throw new IllegalArgumentException("The argument 'classificationName' should not be null."); }
            throw new IllegalStateException("Unknown classification: " + classificationName);
        }
    }
}
