package com.entanmo.etmall.db.domain;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class EtmallDrawExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public EtmallDrawExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public EtmallDrawExample orderBy(String orderByClause) {
        this.setOrderByClause(orderByClause);
        return this;
    }

    public EtmallDrawExample orderBy(String ... orderByClauses) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < orderByClauses.length; i++) {
            sb.append(orderByClauses[i]);
            if (i < orderByClauses.length - 1) {
                sb.append(" , ");
            }
        }
        this.setOrderByClause(sb.toString());
        return this;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria(this);
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    public static Criteria newAndCreateCriteria() {
        EtmallDrawExample example = new EtmallDrawExample();
        return example.createCriteria();
    }

    public EtmallDrawExample when(boolean condition, IExampleWhen then) {
        if (condition) {
            then.example(this);
        }
        return this;
    }

    public EtmallDrawExample when(boolean condition, IExampleWhen then, IExampleWhen otherwise) {
        if (condition) {
            then.example(this);
        } else {
            otherwise.example(this);
        }
        return this;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdEqualToColumn(EtmallDraw.Column column) {
            addCriterion(new StringBuilder("id = ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualToColumn(EtmallDraw.Column column) {
            addCriterion(new StringBuilder("id <> ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanColumn(EtmallDraw.Column column) {
            addCriterion(new StringBuilder("id > ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualToColumn(EtmallDraw.Column column) {
            addCriterion(new StringBuilder("id >= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanColumn(EtmallDraw.Column column) {
            addCriterion(new StringBuilder("id < ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualToColumn(EtmallDraw.Column column) {
            addCriterion(new StringBuilder("id <= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andUseridIsNull() {
            addCriterion("userId is null");
            return (Criteria) this;
        }

        public Criteria andUseridIsNotNull() {
            addCriterion("userId is not null");
            return (Criteria) this;
        }

        public Criteria andUseridEqualTo(Integer value) {
            addCriterion("userId =", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridEqualToColumn(EtmallDraw.Column column) {
            addCriterion(new StringBuilder("userId = ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andUseridNotEqualTo(Integer value) {
            addCriterion("userId <>", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridNotEqualToColumn(EtmallDraw.Column column) {
            addCriterion(new StringBuilder("userId <> ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andUseridGreaterThan(Integer value) {
            addCriterion("userId >", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridGreaterThanColumn(EtmallDraw.Column column) {
            addCriterion(new StringBuilder("userId > ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andUseridGreaterThanOrEqualTo(Integer value) {
            addCriterion("userId >=", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridGreaterThanOrEqualToColumn(EtmallDraw.Column column) {
            addCriterion(new StringBuilder("userId >= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andUseridLessThan(Integer value) {
            addCriterion("userId <", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridLessThanColumn(EtmallDraw.Column column) {
            addCriterion(new StringBuilder("userId < ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andUseridLessThanOrEqualTo(Integer value) {
            addCriterion("userId <=", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridLessThanOrEqualToColumn(EtmallDraw.Column column) {
            addCriterion(new StringBuilder("userId <= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andUseridIn(List<Integer> values) {
            addCriterion("userId in", values, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridNotIn(List<Integer> values) {
            addCriterion("userId not in", values, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridBetween(Integer value1, Integer value2) {
            addCriterion("userId between", value1, value2, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridNotBetween(Integer value1, Integer value2) {
            addCriterion("userId not between", value1, value2, "userid");
            return (Criteria) this;
        }

        public Criteria andSecretIsNull() {
            addCriterion("secret is null");
            return (Criteria) this;
        }

        public Criteria andSecretIsNotNull() {
            addCriterion("secret is not null");
            return (Criteria) this;
        }

        public Criteria andSecretEqualTo(String value) {
            addCriterion("secret =", value, "secret");
            return (Criteria) this;
        }

        public Criteria andSecretEqualToColumn(EtmallDraw.Column column) {
            addCriterion(new StringBuilder("secret = ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andSecretNotEqualTo(String value) {
            addCriterion("secret <>", value, "secret");
            return (Criteria) this;
        }

        public Criteria andSecretNotEqualToColumn(EtmallDraw.Column column) {
            addCriterion(new StringBuilder("secret <> ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andSecretGreaterThan(String value) {
            addCriterion("secret >", value, "secret");
            return (Criteria) this;
        }

        public Criteria andSecretGreaterThanColumn(EtmallDraw.Column column) {
            addCriterion(new StringBuilder("secret > ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andSecretGreaterThanOrEqualTo(String value) {
            addCriterion("secret >=", value, "secret");
            return (Criteria) this;
        }

        public Criteria andSecretGreaterThanOrEqualToColumn(EtmallDraw.Column column) {
            addCriterion(new StringBuilder("secret >= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andSecretLessThan(String value) {
            addCriterion("secret <", value, "secret");
            return (Criteria) this;
        }

        public Criteria andSecretLessThanColumn(EtmallDraw.Column column) {
            addCriterion(new StringBuilder("secret < ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andSecretLessThanOrEqualTo(String value) {
            addCriterion("secret <=", value, "secret");
            return (Criteria) this;
        }

        public Criteria andSecretLessThanOrEqualToColumn(EtmallDraw.Column column) {
            addCriterion(new StringBuilder("secret <= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andSecretLike(String value) {
            addCriterion("secret like", value, "secret");
            return (Criteria) this;
        }

        public Criteria andSecretNotLike(String value) {
            addCriterion("secret not like", value, "secret");
            return (Criteria) this;
        }

        public Criteria andSecretIn(List<String> values) {
            addCriterion("secret in", values, "secret");
            return (Criteria) this;
        }

        public Criteria andSecretNotIn(List<String> values) {
            addCriterion("secret not in", values, "secret");
            return (Criteria) this;
        }

        public Criteria andSecretBetween(String value1, String value2) {
            addCriterion("secret between", value1, value2, "secret");
            return (Criteria) this;
        }

        public Criteria andSecretNotBetween(String value1, String value2) {
            addCriterion("secret not between", value1, value2, "secret");
            return (Criteria) this;
        }

        public Criteria andAmountIsNull() {
            addCriterion("amount is null");
            return (Criteria) this;
        }

        public Criteria andAmountIsNotNull() {
            addCriterion("amount is not null");
            return (Criteria) this;
        }

        public Criteria andAmountEqualTo(String value) {
            addCriterion("amount =", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountEqualToColumn(EtmallDraw.Column column) {
            addCriterion(new StringBuilder("amount = ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andAmountNotEqualTo(String value) {
            addCriterion("amount <>", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountNotEqualToColumn(EtmallDraw.Column column) {
            addCriterion(new StringBuilder("amount <> ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andAmountGreaterThan(String value) {
            addCriterion("amount >", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountGreaterThanColumn(EtmallDraw.Column column) {
            addCriterion(new StringBuilder("amount > ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andAmountGreaterThanOrEqualTo(String value) {
            addCriterion("amount >=", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountGreaterThanOrEqualToColumn(EtmallDraw.Column column) {
            addCriterion(new StringBuilder("amount >= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andAmountLessThan(String value) {
            addCriterion("amount <", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountLessThanColumn(EtmallDraw.Column column) {
            addCriterion(new StringBuilder("amount < ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andAmountLessThanOrEqualTo(String value) {
            addCriterion("amount <=", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountLessThanOrEqualToColumn(EtmallDraw.Column column) {
            addCriterion(new StringBuilder("amount <= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andAmountLike(String value) {
            addCriterion("amount like", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountNotLike(String value) {
            addCriterion("amount not like", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountIn(List<String> values) {
            addCriterion("amount in", values, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountNotIn(List<String> values) {
            addCriterion("amount not in", values, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountBetween(String value1, String value2) {
            addCriterion("amount between", value1, value2, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountNotBetween(String value1, String value2) {
            addCriterion("amount not between", value1, value2, "amount");
            return (Criteria) this;
        }

        public Criteria andAddressIsNull() {
            addCriterion("address is null");
            return (Criteria) this;
        }

        public Criteria andAddressIsNotNull() {
            addCriterion("address is not null");
            return (Criteria) this;
        }

        public Criteria andAddressEqualTo(String value) {
            addCriterion("address =", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressEqualToColumn(EtmallDraw.Column column) {
            addCriterion(new StringBuilder("address = ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andAddressNotEqualTo(String value) {
            addCriterion("address <>", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotEqualToColumn(EtmallDraw.Column column) {
            addCriterion(new StringBuilder("address <> ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andAddressGreaterThan(String value) {
            addCriterion("address >", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressGreaterThanColumn(EtmallDraw.Column column) {
            addCriterion(new StringBuilder("address > ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andAddressGreaterThanOrEqualTo(String value) {
            addCriterion("address >=", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressGreaterThanOrEqualToColumn(EtmallDraw.Column column) {
            addCriterion(new StringBuilder("address >= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andAddressLessThan(String value) {
            addCriterion("address <", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLessThanColumn(EtmallDraw.Column column) {
            addCriterion(new StringBuilder("address < ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andAddressLessThanOrEqualTo(String value) {
            addCriterion("address <=", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLessThanOrEqualToColumn(EtmallDraw.Column column) {
            addCriterion(new StringBuilder("address <= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andAddressLike(String value) {
            addCriterion("address like", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotLike(String value) {
            addCriterion("address not like", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressIn(List<String> values) {
            addCriterion("address in", values, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotIn(List<String> values) {
            addCriterion("address not in", values, "address");
            return (Criteria) this;
        }

        public Criteria andAddressBetween(String value1, String value2) {
            addCriterion("address between", value1, value2, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotBetween(String value1, String value2) {
            addCriterion("address not between", value1, value2, "address");
            return (Criteria) this;
        }

        public Criteria andTransactionid1IsNull() {
            addCriterion("transactionId1 is null");
            return (Criteria) this;
        }

        public Criteria andTransactionid1IsNotNull() {
            addCriterion("transactionId1 is not null");
            return (Criteria) this;
        }

        public Criteria andTransactionid1EqualTo(String value) {
            addCriterion("transactionId1 =", value, "transactionid1");
            return (Criteria) this;
        }

        public Criteria andTransactionid1EqualToColumn(EtmallDraw.Column column) {
            addCriterion(new StringBuilder("transactionId1 = ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andTransactionid1NotEqualTo(String value) {
            addCriterion("transactionId1 <>", value, "transactionid1");
            return (Criteria) this;
        }

        public Criteria andTransactionid1NotEqualToColumn(EtmallDraw.Column column) {
            addCriterion(new StringBuilder("transactionId1 <> ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andTransactionid1GreaterThan(String value) {
            addCriterion("transactionId1 >", value, "transactionid1");
            return (Criteria) this;
        }

        public Criteria andTransactionid1GreaterThanColumn(EtmallDraw.Column column) {
            addCriterion(new StringBuilder("transactionId1 > ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andTransactionid1GreaterThanOrEqualTo(String value) {
            addCriterion("transactionId1 >=", value, "transactionid1");
            return (Criteria) this;
        }

        public Criteria andTransactionid1GreaterThanOrEqualToColumn(EtmallDraw.Column column) {
            addCriterion(new StringBuilder("transactionId1 >= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andTransactionid1LessThan(String value) {
            addCriterion("transactionId1 <", value, "transactionid1");
            return (Criteria) this;
        }

        public Criteria andTransactionid1LessThanColumn(EtmallDraw.Column column) {
            addCriterion(new StringBuilder("transactionId1 < ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andTransactionid1LessThanOrEqualTo(String value) {
            addCriterion("transactionId1 <=", value, "transactionid1");
            return (Criteria) this;
        }

        public Criteria andTransactionid1LessThanOrEqualToColumn(EtmallDraw.Column column) {
            addCriterion(new StringBuilder("transactionId1 <= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andTransactionid1Like(String value) {
            addCriterion("transactionId1 like", value, "transactionid1");
            return (Criteria) this;
        }

        public Criteria andTransactionid1NotLike(String value) {
            addCriterion("transactionId1 not like", value, "transactionid1");
            return (Criteria) this;
        }

        public Criteria andTransactionid1In(List<String> values) {
            addCriterion("transactionId1 in", values, "transactionid1");
            return (Criteria) this;
        }

        public Criteria andTransactionid1NotIn(List<String> values) {
            addCriterion("transactionId1 not in", values, "transactionid1");
            return (Criteria) this;
        }

        public Criteria andTransactionid1Between(String value1, String value2) {
            addCriterion("transactionId1 between", value1, value2, "transactionid1");
            return (Criteria) this;
        }

        public Criteria andTransactionid1NotBetween(String value1, String value2) {
            addCriterion("transactionId1 not between", value1, value2, "transactionid1");
            return (Criteria) this;
        }

        public Criteria andTransactionid2IsNull() {
            addCriterion("transactionId2 is null");
            return (Criteria) this;
        }

        public Criteria andTransactionid2IsNotNull() {
            addCriterion("transactionId2 is not null");
            return (Criteria) this;
        }

        public Criteria andTransactionid2EqualTo(String value) {
            addCriterion("transactionId2 =", value, "transactionid2");
            return (Criteria) this;
        }

        public Criteria andTransactionid2EqualToColumn(EtmallDraw.Column column) {
            addCriterion(new StringBuilder("transactionId2 = ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andTransactionid2NotEqualTo(String value) {
            addCriterion("transactionId2 <>", value, "transactionid2");
            return (Criteria) this;
        }

        public Criteria andTransactionid2NotEqualToColumn(EtmallDraw.Column column) {
            addCriterion(new StringBuilder("transactionId2 <> ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andTransactionid2GreaterThan(String value) {
            addCriterion("transactionId2 >", value, "transactionid2");
            return (Criteria) this;
        }

        public Criteria andTransactionid2GreaterThanColumn(EtmallDraw.Column column) {
            addCriterion(new StringBuilder("transactionId2 > ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andTransactionid2GreaterThanOrEqualTo(String value) {
            addCriterion("transactionId2 >=", value, "transactionid2");
            return (Criteria) this;
        }

        public Criteria andTransactionid2GreaterThanOrEqualToColumn(EtmallDraw.Column column) {
            addCriterion(new StringBuilder("transactionId2 >= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andTransactionid2LessThan(String value) {
            addCriterion("transactionId2 <", value, "transactionid2");
            return (Criteria) this;
        }

        public Criteria andTransactionid2LessThanColumn(EtmallDraw.Column column) {
            addCriterion(new StringBuilder("transactionId2 < ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andTransactionid2LessThanOrEqualTo(String value) {
            addCriterion("transactionId2 <=", value, "transactionid2");
            return (Criteria) this;
        }

        public Criteria andTransactionid2LessThanOrEqualToColumn(EtmallDraw.Column column) {
            addCriterion(new StringBuilder("transactionId2 <= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andTransactionid2Like(String value) {
            addCriterion("transactionId2 like", value, "transactionid2");
            return (Criteria) this;
        }

        public Criteria andTransactionid2NotLike(String value) {
            addCriterion("transactionId2 not like", value, "transactionid2");
            return (Criteria) this;
        }

        public Criteria andTransactionid2In(List<String> values) {
            addCriterion("transactionId2 in", values, "transactionid2");
            return (Criteria) this;
        }

        public Criteria andTransactionid2NotIn(List<String> values) {
            addCriterion("transactionId2 not in", values, "transactionid2");
            return (Criteria) this;
        }

        public Criteria andTransactionid2Between(String value1, String value2) {
            addCriterion("transactionId2 between", value1, value2, "transactionid2");
            return (Criteria) this;
        }

        public Criteria andTransactionid2NotBetween(String value1, String value2) {
            addCriterion("transactionId2 not between", value1, value2, "transactionid2");
            return (Criteria) this;
        }

        public Criteria andTransactionid3IsNull() {
            addCriterion("transactionId3 is null");
            return (Criteria) this;
        }

        public Criteria andTransactionid3IsNotNull() {
            addCriterion("transactionId3 is not null");
            return (Criteria) this;
        }

        public Criteria andTransactionid3EqualTo(String value) {
            addCriterion("transactionId3 =", value, "transactionid3");
            return (Criteria) this;
        }

        public Criteria andTransactionid3EqualToColumn(EtmallDraw.Column column) {
            addCriterion(new StringBuilder("transactionId3 = ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andTransactionid3NotEqualTo(String value) {
            addCriterion("transactionId3 <>", value, "transactionid3");
            return (Criteria) this;
        }

        public Criteria andTransactionid3NotEqualToColumn(EtmallDraw.Column column) {
            addCriterion(new StringBuilder("transactionId3 <> ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andTransactionid3GreaterThan(String value) {
            addCriterion("transactionId3 >", value, "transactionid3");
            return (Criteria) this;
        }

        public Criteria andTransactionid3GreaterThanColumn(EtmallDraw.Column column) {
            addCriterion(new StringBuilder("transactionId3 > ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andTransactionid3GreaterThanOrEqualTo(String value) {
            addCriterion("transactionId3 >=", value, "transactionid3");
            return (Criteria) this;
        }

        public Criteria andTransactionid3GreaterThanOrEqualToColumn(EtmallDraw.Column column) {
            addCriterion(new StringBuilder("transactionId3 >= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andTransactionid3LessThan(String value) {
            addCriterion("transactionId3 <", value, "transactionid3");
            return (Criteria) this;
        }

        public Criteria andTransactionid3LessThanColumn(EtmallDraw.Column column) {
            addCriterion(new StringBuilder("transactionId3 < ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andTransactionid3LessThanOrEqualTo(String value) {
            addCriterion("transactionId3 <=", value, "transactionid3");
            return (Criteria) this;
        }

        public Criteria andTransactionid3LessThanOrEqualToColumn(EtmallDraw.Column column) {
            addCriterion(new StringBuilder("transactionId3 <= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andTransactionid3Like(String value) {
            addCriterion("transactionId3 like", value, "transactionid3");
            return (Criteria) this;
        }

        public Criteria andTransactionid3NotLike(String value) {
            addCriterion("transactionId3 not like", value, "transactionid3");
            return (Criteria) this;
        }

        public Criteria andTransactionid3In(List<String> values) {
            addCriterion("transactionId3 in", values, "transactionid3");
            return (Criteria) this;
        }

        public Criteria andTransactionid3NotIn(List<String> values) {
            addCriterion("transactionId3 not in", values, "transactionid3");
            return (Criteria) this;
        }

        public Criteria andTransactionid3Between(String value1, String value2) {
            addCriterion("transactionId3 between", value1, value2, "transactionid3");
            return (Criteria) this;
        }

        public Criteria andTransactionid3NotBetween(String value1, String value2) {
            addCriterion("transactionId3 not between", value1, value2, "transactionid3");
            return (Criteria) this;
        }

        public Criteria andAddTimeIsNull() {
            addCriterion("add_time is null");
            return (Criteria) this;
        }

        public Criteria andAddTimeIsNotNull() {
            addCriterion("add_time is not null");
            return (Criteria) this;
        }

        public Criteria andAddTimeEqualTo(LocalDateTime value) {
            addCriterion("add_time =", value, "addTime");
            return (Criteria) this;
        }

        public Criteria andAddTimeEqualToColumn(EtmallDraw.Column column) {
            addCriterion(new StringBuilder("add_time = ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andAddTimeNotEqualTo(LocalDateTime value) {
            addCriterion("add_time <>", value, "addTime");
            return (Criteria) this;
        }

        public Criteria andAddTimeNotEqualToColumn(EtmallDraw.Column column) {
            addCriterion(new StringBuilder("add_time <> ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andAddTimeGreaterThan(LocalDateTime value) {
            addCriterion("add_time >", value, "addTime");
            return (Criteria) this;
        }

        public Criteria andAddTimeGreaterThanColumn(EtmallDraw.Column column) {
            addCriterion(new StringBuilder("add_time > ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andAddTimeGreaterThanOrEqualTo(LocalDateTime value) {
            addCriterion("add_time >=", value, "addTime");
            return (Criteria) this;
        }

        public Criteria andAddTimeGreaterThanOrEqualToColumn(EtmallDraw.Column column) {
            addCriterion(new StringBuilder("add_time >= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andAddTimeLessThan(LocalDateTime value) {
            addCriterion("add_time <", value, "addTime");
            return (Criteria) this;
        }

        public Criteria andAddTimeLessThanColumn(EtmallDraw.Column column) {
            addCriterion(new StringBuilder("add_time < ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andAddTimeLessThanOrEqualTo(LocalDateTime value) {
            addCriterion("add_time <=", value, "addTime");
            return (Criteria) this;
        }

        public Criteria andAddTimeLessThanOrEqualToColumn(EtmallDraw.Column column) {
            addCriterion(new StringBuilder("add_time <= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andAddTimeIn(List<LocalDateTime> values) {
            addCriterion("add_time in", values, "addTime");
            return (Criteria) this;
        }

        public Criteria andAddTimeNotIn(List<LocalDateTime> values) {
            addCriterion("add_time not in", values, "addTime");
            return (Criteria) this;
        }

        public Criteria andAddTimeBetween(LocalDateTime value1, LocalDateTime value2) {
            addCriterion("add_time between", value1, value2, "addTime");
            return (Criteria) this;
        }

        public Criteria andAddTimeNotBetween(LocalDateTime value1, LocalDateTime value2) {
            addCriterion("add_time not between", value1, value2, "addTime");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {
        private EtmallDrawExample example;

        protected Criteria(EtmallDrawExample example) {
            super();
            this.example = example;
        }

        public EtmallDrawExample example() {
            return this.example;
        }

        @Deprecated
        public Criteria andIf(boolean ifAdd, ICriteriaAdd add) {
            if (ifAdd) {
                add.add(this);
            }
            return this;
        }

        public Criteria when(boolean condition, ICriteriaWhen then) {
            if (condition) {
                then.criteria(this);
            }
            return this;
        }

        public Criteria when(boolean condition, ICriteriaWhen then, ICriteriaWhen otherwise) {
            if (condition) {
                then.criteria(this);
            } else {
                otherwise.criteria(this);
            }
            return this;
        }

        @Deprecated
        public interface ICriteriaAdd {
            Criteria add(Criteria add);
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }

    public interface ICriteriaWhen {
        void criteria(Criteria criteria);
    }

    public interface IExampleWhen {
        void example(com.entanmo.etmall.db.domain.EtmallDrawExample example);
    }
}