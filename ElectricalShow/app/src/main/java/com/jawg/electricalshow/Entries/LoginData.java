package com.jawg.electricalshow.Entries;

public class LoginData {


    /**
     * code : 200
     * msg : 操作成功，请求成功!
     * result : {"com_id":"1","u_id":"1","api_token":"df0f4d82c67f3f11376ad0c1828b472f","u_photo":"http://jn.xiaofang365.cn/picture/1.jpg","bloc":"1","phone":"18888888888"}
     */

    private int code;
    private String msg;
    private ResultBean result;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public ResultBean getResult() {
        return result;
    }

    public void setResult(ResultBean result) {
        this.result = result;
    }

    public static class ResultBean {
        /**
         * com_id : 1
         * u_id : 1
         * api_token : df0f4d82c67f3f11376ad0c1828b472f
         * u_photo : http://jn.xiaofang365.cn/picture/1.jpg
         * bloc : 1
         * phone : 18888888888
         */

        private String com_id;
        private String u_id;
        private String api_token;
        private String u_photo;
        private String bloc;
        private String phone;

        public String getCom_id() {
            return com_id;
        }

        public void setCom_id(String com_id) {
            this.com_id = com_id;
        }

        public String getU_id() {
            return u_id;
        }

        public void setU_id(String u_id) {
            this.u_id = u_id;
        }

        public String getApi_token() {
            return api_token;
        }

        public void setApi_token(String api_token) {
            this.api_token = api_token;
        }

        public String getU_photo() {
            return u_photo;
        }

        public void setU_photo(String u_photo) {
            this.u_photo = u_photo;
        }

        public String getBloc() {
            return bloc;
        }

        public void setBloc(String bloc) {
            this.bloc = bloc;
        }

        public String getPhone() {
            return phone;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }
    }
}
