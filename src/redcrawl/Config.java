/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package redcrawl;

/**
 *
 * @author me
 */
public class Config {
    private String urlSave;
    private String percentResize;
    private int isDownloadMockup;
    private String soluongds;

    public int getIsDownloadMockup() {
        return isDownloadMockup;
    }

    public void setIsDownloadMockup(int isDownloadMockup) {
        this.isDownloadMockup = isDownloadMockup;
    }
    private String rong,dai;

    public String getUrlSave() {
        return urlSave;
    }

    public void setUrlSave(String urlSave) {
        this.urlSave = urlSave;
    }

    public String getPercentResize() {
        return percentResize;
    }

    public void setPercentResize(String percentResize) {
        this.percentResize = percentResize;
    }

    public String getSoluongds() {
        return soluongds;
    }

    public void setSoluongds(String soluongds) {
        this.soluongds = soluongds;
    }

    public String getRong() {
        return rong;
    }

    public void setRong(String rong) {
        this.rong = rong;
    }

    public String getDai() {
        return dai;
    }

    public void setDai(String dai) {
        this.dai = dai;
    }
}
