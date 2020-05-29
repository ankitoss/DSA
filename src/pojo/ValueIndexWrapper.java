package pojo;

/**
 * this class is meant to bind values with their indexes when you want
 * to sort those values but want to preserve the indexes as well
 */
public class ValueIndexWrapper {

    private Integer index;
    private Integer val;

    public ValueIndexWrapper(Integer index, Integer val) {
        this.index = index;
        this.val = val;
    }

    public Integer getIndex() {
        return index;
    }

    public Integer getVal() {
        return val;
    }
}
