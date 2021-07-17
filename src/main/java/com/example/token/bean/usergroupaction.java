package com.example.token.bean;

public class usergroupaction {
        private int userid;
        private int groupid;
        private int actionid;

        public int getUserid() {
            return userid;
        }

        public void setUserid(int userid) {
            this.userid = userid;
        }

        public int getGroupid() {
            return groupid;
        }

        public void setGroupid(int groupid) {
            this.groupid = groupid;
        }

        public int getActionid() {
            return actionid;
        }

        public void setActionid(int actionid) {
            this.actionid = actionid;
        }

        @Override
        public String toString() {
            return "usergroupaction{" +
                    "userid=" + userid +
                    ", groupid=" + groupid +
                    ", actionid=" + actionid +
                    '}';
        }
}
