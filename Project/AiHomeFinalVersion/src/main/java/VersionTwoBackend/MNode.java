package VersionTwoBackend;

import java.util.ArrayList;
import java.util.List;

public class MNode {
    public List<MNode> Childrens;
    public List <Integer> Values;
    public int NimSum;
    public int ActualSum;
    public int MinMax;
    public boolean isLeaf;

    public MNode() {
        this.Childrens =new ArrayList<>();
        this.Values =new ArrayList<>();
        this.NimSum=-1;
        this.ActualSum=0;
        this.MinMax=0;
        this.isLeaf=false;
    }

    public MNode(List<Integer> tempList,int ActualSum,int NimSum) {
        this.Childrens =new ArrayList<>();
        this.Values = tempList;
        this.NimSum=NimSum;
        this.ActualSum=ActualSum;
        this.MinMax=0;
        this.isLeaf=false;
    }

    public MNode(List<Integer> tempList, int actualSum, int nimSum, boolean isLeaf) {
        this.Values=tempList;
        this.ActualSum=actualSum;
        this.NimSum=nimSum;
        this.isLeaf=isLeaf;
    }
}
