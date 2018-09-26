package com.jawg.electricalshow.Entries;

import java.util.List;

public class PerMituInfo {


    /**
     * info : success
     * result : {"count":1,"data":[{"id":"515","mic":"867793032915417","port":"a1","original_value":"1063","timestamp":"1537426672"}]}
     */

    private String info;
    private ResultBean result;

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public ResultBean getResult() {
        return result;
    }

    public void setResult(ResultBean result) {
        this.result = result;
    }

    public static class ResultBean {
        /**
         * count : 1
         * data : [{"id":"515","mic":"867793032915417","port":"a1","original_value":"1063","timestamp":"1537426672"}]
         */

        private int count;
        private List<DataBean> data;

        public int getCount() {
            return count;
        }

        public void setCount(int count) {
            this.count = count;
        }

        public List<DataBean> getData() {
            return data;
        }

        public void setData(List<DataBean> data) {
            this.data = data;
        }

        public static class DataBean {
            /**
             * id : 515
             * mic : 867793032915417
             * port : a1
             * original_value : 1063
             * timestamp : 1537426672
             */

            private String id;
            private String mic;
            private String port;
            private String original_value;
            private String timestamp;

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getMic() {
                return mic;
            }

            public void setMic(String mic) {
                this.mic = mic;
            }

            public String getPort() {
                return port;
            }

            public void setPort(String port) {
                this.port = port;
            }

            public String getOriginal_value() {
                return original_value;
            }

            public void setOriginal_value(String original_value) {
                this.original_value = original_value;
            }

            public String getTimestamp() {
                return timestamp;
            }

            public void setTimestamp(String timestamp) {
                this.timestamp = timestamp;
            }
        }
    }
}
