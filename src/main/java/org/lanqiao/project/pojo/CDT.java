package org.lanqiao.project.pojo;

//@Getter
//@Setter
//@ToString
//@Builder
//@AllArgsConstructor
//@NoArgsConstructor
public class CDT {
    private double begprice;
    private double endprice;

    public CDT() {
    }



    public CDT(double begprice, double endprice) {
        this.begprice = begprice;
        this.endprice = endprice;
    }

    public double getBegprice() {
        return begprice;
    }

    public void setBegprice(double begprice) {
        this.begprice = begprice;
    }

    public double getEndprice() {
        return endprice;
    }

    public void setEndprice(double endprice) {
        this.endprice = endprice;
    }

    @Override
    public String toString() {
        return "CDT{" +
                "begprice=" + begprice +
                ", endprice=" + endprice +
                '}';
    }
}
