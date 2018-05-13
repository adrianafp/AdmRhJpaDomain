package uy.org.aladi.admrh.jpadomain.repository.criteria;


public class Range {

    private Integer minIndex;

    private Integer maxIndex;

    public Range(Integer minIndex, Integer length) {
        this.maxIndex = minIndex + length;
        this.minIndex = minIndex;
    }

    public Integer getMaxIndex() {
        return maxIndex;
    }

    public Integer getMinIndex() {
        return minIndex;
    }

    public Integer length() {
        return maxIndex - minIndex;
    }
}
