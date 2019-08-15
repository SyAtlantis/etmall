package com.entanmo.etmall.db.domain;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;

public class EtmallDraw {
    private Integer id;

    private Integer userid;

    private String secret;

    private String amount;

    private String address;

    private String transactionid1;

    private String transactionid2;

    private String transactionid3;

    private LocalDateTime addTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public String getSecret() {
        return secret;
    }

    public void setSecret(String secret) {
        this.secret = secret;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTransactionid1() {
        return transactionid1;
    }

    public void setTransactionid1(String transactionid1) {
        this.transactionid1 = transactionid1;
    }

    public String getTransactionid2() {
        return transactionid2;
    }

    public void setTransactionid2(String transactionid2) {
        this.transactionid2 = transactionid2;
    }

    public String getTransactionid3() {
        return transactionid3;
    }

    public void setTransactionid3(String transactionid3) {
        this.transactionid3 = transactionid3;
    }

    public LocalDateTime getAddTime() {
        return addTime;
    }

    public void setAddTime(LocalDateTime addTime) {
        this.addTime = addTime;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", userid=").append(userid);
        sb.append(", secret=").append(secret);
        sb.append(", amount=").append(amount);
        sb.append(", address=").append(address);
        sb.append(", transactionid1=").append(transactionid1);
        sb.append(", transactionid2=").append(transactionid2);
        sb.append(", transactionid3=").append(transactionid3);
        sb.append(", addTime=").append(addTime);
        sb.append("]");
        return sb.toString();
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        EtmallDraw other = (EtmallDraw) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getUserid() == null ? other.getUserid() == null : this.getUserid().equals(other.getUserid()))
            && (this.getSecret() == null ? other.getSecret() == null : this.getSecret().equals(other.getSecret()))
            && (this.getAmount() == null ? other.getAmount() == null : this.getAmount().equals(other.getAmount()))
            && (this.getAddress() == null ? other.getAddress() == null : this.getAddress().equals(other.getAddress()))
            && (this.getTransactionid1() == null ? other.getTransactionid1() == null : this.getTransactionid1().equals(other.getTransactionid1()))
            && (this.getTransactionid2() == null ? other.getTransactionid2() == null : this.getTransactionid2().equals(other.getTransactionid2()))
            && (this.getTransactionid3() == null ? other.getTransactionid3() == null : this.getTransactionid3().equals(other.getTransactionid3()))
            && (this.getAddTime() == null ? other.getAddTime() == null : this.getAddTime().equals(other.getAddTime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getUserid() == null) ? 0 : getUserid().hashCode());
        result = prime * result + ((getSecret() == null) ? 0 : getSecret().hashCode());
        result = prime * result + ((getAmount() == null) ? 0 : getAmount().hashCode());
        result = prime * result + ((getAddress() == null) ? 0 : getAddress().hashCode());
        result = prime * result + ((getTransactionid1() == null) ? 0 : getTransactionid1().hashCode());
        result = prime * result + ((getTransactionid2() == null) ? 0 : getTransactionid2().hashCode());
        result = prime * result + ((getTransactionid3() == null) ? 0 : getTransactionid3().hashCode());
        result = prime * result + ((getAddTime() == null) ? 0 : getAddTime().hashCode());
        return result;
    }

    public enum Column {
        id("id", "id", "INTEGER", false),
        userid("userId", "userid", "INTEGER", false),
        secret("secret", "secret", "VARCHAR", false),
        amount("amount", "amount", "VARCHAR", false),
        address("address", "address", "VARCHAR", false),
        transactionid1("transactionId1", "transactionid1", "VARCHAR", false),
        transactionid2("transactionId2", "transactionid2", "VARCHAR", false),
        transactionid3("transactionId3", "transactionid3", "VARCHAR", false),
        addTime("add_time", "addTime", "TIMESTAMP", false);

        private static final String BEGINNING_DELIMITER = "`";

        private static final String ENDING_DELIMITER = "`";

        private final String column;

        private final boolean isColumnNameDelimited;

        private final String javaProperty;

        private final String jdbcType;

        public String value() {
            return this.column;
        }

        public String getValue() {
            return this.column;
        }

        public String getJavaProperty() {
            return this.javaProperty;
        }

        public String getJdbcType() {
            return this.jdbcType;
        }

        Column(String column, String javaProperty, String jdbcType, boolean isColumnNameDelimited) {
            this.column = column;
            this.javaProperty = javaProperty;
            this.jdbcType = jdbcType;
            this.isColumnNameDelimited = isColumnNameDelimited;
        }

        public String desc() {
            return this.getEscapedColumnName() + " DESC";
        }

        public String asc() {
            return this.getEscapedColumnName() + " ASC";
        }

        public static Column[] excludes(Column ... excludes) {
            ArrayList<Column> columns = new ArrayList<>(Arrays.asList(Column.values()));
            if (excludes != null && excludes.length > 0) {
                columns.removeAll(new ArrayList<>(Arrays.asList(excludes)));
            }
            return columns.toArray(new Column[]{});
        }

        public String getEscapedColumnName() {
            if (this.isColumnNameDelimited) {
                return new StringBuilder().append(BEGINNING_DELIMITER).append(this.column).append(ENDING_DELIMITER).toString();
            } else {
                return this.column;
            }
        }

        public String getAliasedEscapedColumnName() {
            return this.getEscapedColumnName();
        }
    }
}