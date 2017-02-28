package com.lin.cainiaolives.ui.login.bean;

/**
 * Created by Administrator on 2017/2/15.
 */

public class Login {

    /**
     * status : 0
     * msg : 请求成功
     * data : {"nickname":"zhm010","sex":"0","head_pic":"12313","status":"1","sig_id":"eJxlz1tPgzAYBuB7fgXhdkbbWrD1Tth0DLbFAHFekQ46*GI42FXHMP73TdRI4vXzfof3wzBN04rD6FJkWfNW61QfW2mZt6aFrIs-bFvIU6HTa5X-Q9m1oGQqdlqqAYnNCULjCOSy1rCD34Azsn3*kg77B8L0PEkIYWwcgWLA5ezZ8x*9ZQTJYoK0WMfqYRs89aLxD1h0m617oH4E97O5fZP1uV8WfnkXvsJ0U6wqJWjDFkeHuiKqAs9rY6dP6sSlOlhPy0k3vwpHJzVU8uchRjhn1OYjfZdqD039XQZhG2PM0Vdl49M4ARlPW18_","user_id":"26"}
     */

    private int status;
    private String msg;
    private DataBean data;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * nickname : zhm010
         * sex : 0
         * head_pic : 12313
         * status : 1
         * sig_id : eJxlz1tPgzAYBuB7fgXhdkbbWrD1Tth0DLbFAHFekQ46*GI42FXHMP73TdRI4vXzfof3wzBN04rD6FJkWfNW61QfW2mZt6aFrIs-bFvIU6HTa5X-Q9m1oGQqdlqqAYnNCULjCOSy1rCD34Azsn3*kg77B8L0PEkIYWwcgWLA5ezZ8x*9ZQTJYoK0WMfqYRs89aLxD1h0m617oH4E97O5fZP1uV8WfnkXvsJ0U6wqJWjDFkeHuiKqAs9rY6dP6sSlOlhPy0k3vwpHJzVU8uchRjhn1OYjfZdqD039XQZhG2PM0Vdl49M4ARlPW18_
         * user_id : 26
         */

        private String nickname;
        private String sex;
        private String head_pic;
        private String status;
        private String sig_id;
        private String user_id;

        public String getNickname() {
            return nickname;
        }

        public void setNickname(String nickname) {
            this.nickname = nickname;
        }

        public String getSex() {
            return sex;
        }

        public void setSex(String sex) {
            this.sex = sex;
        }

        public String getHead_pic() {
            return head_pic;
        }

        public void setHead_pic(String head_pic) {
            this.head_pic = head_pic;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public String getSig_id() {
            return sig_id;
        }

        public void setSig_id(String sig_id) {
            this.sig_id = sig_id;
        }

        public String getUser_id() {
            return user_id;
        }

        public void setUser_id(String user_id) {
            this.user_id = user_id;
        }
    }
}
