class TimeMap {

        Map<String, String> keyValueMap = new HashMap<>();

        public TimeMap() {

        }

        public void set(String key, String value, int timestamp) {
            keyValueMap.put(key + timestamp, value);

        }

        public String get(String key, int timestamp) {
            while (timestamp > 0) {
                if (keyValueMap.get(key + timestamp) != null) {
                    return keyValueMap.get(key + timestamp);
                }
                timestamp--;
            }
            return "";
        }
    }
