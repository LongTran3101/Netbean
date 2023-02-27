/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package redcrawl;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.collect.Lists;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileNotFoundException;

import java.io.FileWriter;

import java.io.InputStreamReader;
import java.net.HttpURLConnection;

import java.net.NetworkInterface;

import java.net.URLConnection;

import java.util.Enumeration;

import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

import javax.swing.JOptionPane;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.awt.image.WritableRaster;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.security.CodeSource;
import java.security.ProtectionDomain;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JFileChooser;
import javax.swing.SwingWorker;
import org.apache.http.HttpEntity;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.imgscalr.Scalr;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import static redcrawl.ebay.setStatus;
import static redcrawl.ebay.status;

/**
 *
 * @author me
 */
public class zazzle extends javax.swing.JFrame {

    public static String status = "";
    private final String USER_AGENT = "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/109.0.0.0 Safari/537.36";
    /**
     *
     * Creates new form downloadanh
     */
    JFileChooser chooser;
    String choosertitle;
    String stringUrlSave;
    static String Key;
    private Document page;

    public zazzle() {

        initComponents();
    }

    private static BufferedImage trimImage(BufferedImage image) {
        try {

            WritableRaster raster = image.getAlphaRaster();
            int width = raster.getWidth();
            int height = raster.getHeight();
            int left = 0;
            int top = 0;
            int right = width - 1;
            int bottom = height - 1;
            int minRight = width - 1;
            int minBottom = height - 1;

            top:
            for (; top < bottom; top++) {
                for (int x = 0; x < width; x++) {
                    if (raster.getSample(x, top, 0) != 0) {
                        minRight = x;
                        minBottom = top;
                        break top;
                    }
                }
            }

            left:
            for (; left < minRight; left++) {
                for (int y = height - 1; y > top; y--) {
                    if (raster.getSample(left, y, 0) != 0) {
                        minBottom = y;
                        break left;
                    }
                }
            }

            bottom:
            for (; bottom > minBottom; bottom--) {
                for (int x = width - 1; x >= left; x--) {
                    if (raster.getSample(x, bottom, 0) != 0) {
                        minRight = x;
                        break bottom;
                    }
                }
            }

            right:
            for (; right > minRight; right--) {
                for (int y = bottom; y >= top; y--) {
                    if (raster.getSample(right, y, 0) != 0) {
                        break right;
                    }
                }
            }
            return image.getSubimage(left, top, right - left + 1, bottom - top + 1);
        } catch (Exception e) {
            return image;
        }

    }

    public static BufferedImage joinBufferedImage(BufferedImage img1, BufferedImage img2, int wid, int height) {

        //do some calculate first
        int offset = 5;

        //create a new buffer and draw two image into the new image
        BufferedImage newImage = new BufferedImage(wid, height, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2 = newImage.createGraphics();
//        Color oldColor = g2.getColor();
//        //fill background
//        
//        g2.fillRect(0, 0, wid, height);
//        //draw image

        g2.drawImage(img1, null, 0, 0);
        g2.drawImage(img2, null, img1.getWidth() + offset, 0);
        g2.dispose();
        return newImage;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        jButton1 = new javax.swing.JButton();
        result = new javax.swing.JLabel();
        buttonChosefoder = new javax.swing.JButton();
        linkSaveFile = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        abcxyz = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        textURLForder = new javax.swing.JTextField();
        theolink = new javax.swing.JRadioButton();
        theofile = new javax.swing.JRadioButton();
        jButton2 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        makey = new javax.swing.JTextArea();
        jLabel3 = new javax.swing.JLabel();
        keyApi = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();
        width = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        hight = new javax.swing.JTextField();
        checkresize = new javax.swing.JCheckBox();
        theopage = new javax.swing.JRadioButton();
        jLabel6 = new javax.swing.JLabel();
        tagex = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        soluongDS = new javax.swing.JTextField();
        cantren = new javax.swing.JRadioButton();
        cangiua = new javax.swing.JRadioButton();
        tileresize = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jRadioButton1 = new javax.swing.JRadioButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        cokie = new javax.swing.JTextArea();
        jLabel9 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("TOOL CRAWL RED");

        jButton1.setText("download");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        buttonChosefoder.setText("Chọn thư mục lưu");
        buttonChosefoder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonChosefoderActionPerformed(evt);
            }
        });

        linkSaveFile.setText("C:\\Users\\me\\Desktop\\tpl\\");
            linkSaveFile.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    linkSaveFileActionPerformed(evt);
                }
            });

            abcxyz.setColumns(20);
            abcxyz.setRows(5);
            jScrollPane1.setViewportView(abcxyz);

            jLabel1.setText("Link áo");

            textURLForder.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    textURLForderActionPerformed(evt);
                }
            });

            buttonGroup1.add(theolink);
            theolink.setText("Theo Link");
            theolink.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    theolinkActionPerformed(evt);
                }
            });

            buttonGroup1.add(theofile);
            theofile.setSelected(true);
            theofile.setText("Nhiều link");

            jButton2.setText("tạo key");
            jButton2.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    jButton2ActionPerformed(evt);
                }
            });

            makey.setColumns(20);
            makey.setRows(5);
            jScrollPane2.setViewportView(makey);

            jLabel3.setText("Key");

            jLabel2.setText("FB");

            jTextField1.setEditable(false);
            jTextField1.setText("fb.com/cwalk.rua");

            jTextField2.setEditable(false);
            jTextField2.setText("0985651126");
            jTextField2.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    jTextField2ActionPerformed(evt);
                }
            });

            jLabel4.setText("Phone");

            jTextField3.setEditable(false);
            jTextField3.setHorizontalAlignment(javax.swing.JTextField.CENTER);
            jTextField3.setText("Mỗi ngày mỗi key chỉ sử dụng được trên một máy");
            jTextField3.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    jTextField3ActionPerformed(evt);
                }
            });

            jTextField4.setEditable(false);
            jTextField4.setHorizontalAlignment(javax.swing.JTextField.CENTER);
            jTextField4.setText("Liên hệ để kich hoạt key");

            width.setText("4500");

            jLabel5.setText("X");

            hight.setText("5400");

            checkresize.setSelected(true);
            checkresize.setText("resize");

            buttonGroup1.add(theopage);
            theopage.setText("Theo page");

            jLabel6.setText("key word cần lọc");

            tagex.setText("to,or,the,and,is,in");
            tagex.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    tagexActionPerformed(evt);
                }
            });

            jLabel7.setText("Số lượng DS");

            soluongDS.setText("2000");
            soluongDS.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    soluongDSActionPerformed(evt);
                }
            });

            buttonGroup2.add(cantren);
            cantren.setSelected(true);
            cantren.setText("căn trên");
            cantren.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    cantrenActionPerformed(evt);
                }
            });

            buttonGroup2.add(cangiua);
            cangiua.setText("căn giữa");

            tileresize.setText("80");

            jLabel8.setText("tỉ lệ resize");

            jRadioButton1.setText("Download mockup");
            jRadioButton1.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    jRadioButton1ActionPerformed(evt);
                }
            });

            cokie.setColumns(20);
            cokie.setRows(5);
            jScrollPane3.setViewportView(cokie);

            jLabel9.setText("cokie");

            javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
            getContentPane().setLayout(layout);
            layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 434, Short.MAX_VALUE)
                                            .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(112, 112, 112))
                                        .addGroup(layout.createSequentialGroup()
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(layout.createSequentialGroup()
                                                    .addComponent(checkresize)
                                                    .addGap(242, 242, 242)
                                                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                    .addComponent(hight, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                .addGroup(layout.createSequentialGroup()
                                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(layout.createSequentialGroup()
                                                            .addComponent(jRadioButton1)
                                                            .addGap(135, 135, 135))
                                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                                                    .addComponent(jScrollPane3))
                                                .addGroup(layout.createSequentialGroup()
                                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                        .addGroup(layout.createSequentialGroup()
                                                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                            .addComponent(soluongDS))
                                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                            .addGroup(layout.createSequentialGroup()
                                                                .addComponent(theolink)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                                    .addComponent(theofile, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                    .addComponent(width, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(layout.createSequentialGroup()
                                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                .addGroup(layout.createSequentialGroup()
                                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                    .addComponent(theopage))
                                                                .addGroup(layout.createSequentialGroup()
                                                                    .addGap(56, 56, 56)
                                                                    .addComponent(cantren)
                                                                    .addGap(18, 18, 18)
                                                                    .addComponent(cangiua)))
                                                            .addGap(0, 0, Short.MAX_VALUE))
                                                        .addGroup(layout.createSequentialGroup()
                                                            .addGap(18, 18, 18)
                                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                .addComponent(tagex)
                                                                .addComponent(jScrollPane1))))))
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                                    .addComponent(result))
                                .addComponent(jTextField4)
                                .addComponent(jTextField3, javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(176, 176, 176)
                                    .addComponent(linkSaveFile))
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(0, 0, Short.MAX_VALUE)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(18, 18, 18)
                                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(18, 18, 18)
                                            .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGap(18, 18, 18)
                                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(17, 17, 17)))
                            .addGap(20, 20, 20))
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(tileresize))
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(buttonChosefoder)
                                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGap(34, 34, 34)))
                            .addGap(108, 108, 108)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(textURLForder)
                                .addComponent(keyApi))
                            .addContainerGap())))
            );
            layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(23, 23, 23)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel3)
                        .addComponent(keyApi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1)
                        .addComponent(textURLForder, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(18, 18, 18)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(buttonChosefoder, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(linkSaveFile, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(79, 79, 79)
                            .addComponent(result)
                            .addGap(25, 25, 25))
                        .addGroup(layout.createSequentialGroup()
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(tileresize, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel9))
                                        .addGroup(layout.createSequentialGroup()
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 3, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel8)))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jRadioButton1))
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(18, 18, 18)))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(theolink)
                        .addComponent(theofile)
                        .addComponent(theopage))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel7)
                                .addComponent(soluongDS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(width, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(hight, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(checkresize)))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(7, 7, 7)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(cantren)
                                .addComponent(cangiua))))
                    .addGap(3, 3, 3)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel6)
                        .addComponent(tagex, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addComponent(jButton2)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel2)
                                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel4))
                            .addGap(71, 71, 71))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addContainerGap())))
            );

            pack();
        }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        this.jButton1.setEnabled(false);
        Thread thread = new Thread(new Runnable() {

            public void run() {
                download();

            }
        });
        thread.start();

    }//GEN-LAST:event_jButton1ActionPerformed

    public void download() {
        try {
            int countDown = 1;

            Key = keyApi.getText();

            if (Key == null || Key.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Nhập key");
                return;
            }
            ProtectionDomain pd = zazzle.class.getProtectionDomain();
            CodeSource cs = pd.getCodeSource();
            URL location = cs.getLocation();

            File directory4 = new File(location.getPath());
            String PathLocal = directory4.getParentFile().getPath().replace("%20", " ");
            System.out.println(PathLocal);
            Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
            String adip = "";
            List<String> adress = new ArrayList<>();
            String cokiestr = this.cokie.getText();
            while (networkInterfaces.hasMoreElements()) {
                NetworkInterface ni = networkInterfaces.nextElement();
                byte[] hardwareAddress = ni.getHardwareAddress();
                if (hardwareAddress != null) {
                    String[] hexadecimalFormat = new String[hardwareAddress.length];
                    for (int i = 0; i < hardwareAddress.length; i++) {
                        hexadecimalFormat[i] = String.format("%02X", hardwareAddress[i]);
                    }
                    adress.add(String.join("-", hexadecimalFormat));
                    //System.out.println(String.join("-", hexadecimalFormat));
                }
            }

            adip = String.join(",", adress);
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            String filename = PathLocal + "./key.txt";
            FileWriter fw = new FileWriter(filename); //the true will append the new data
            fw.write("");//appends the string to the file
            fw.close();
            FileWriter fw2 = new FileWriter(filename); //the true will append the new data
            fw2.write(String.valueOf(Key));//appends the string to the file
            fw2.close();
            Config conf = new Config();
            conf.setDai(this.hight.getText());
            conf.setPercentResize(this.tileresize.getText());
            conf.setRong(this.width.getText());
            conf.setSoluongds(this.soluongDS.getText());
            conf.setUrlSave(this.linkSaveFile.getText());
            if (this.jRadioButton1.isSelected()) {
                conf.setIsDownloadMockup(1);
            } else {
                conf.setIsDownloadMockup(0);
            }

            String configInfo = gson.toJson(conf);
            String fileconfig = PathLocal + "./config.txt";
            fw = new FileWriter(fileconfig); //the true will append the new data
            fw.write("");//appends the string to the file
            fw.close();
            fw = new FileWriter(fileconfig); //the true will append the new data
            fw.write(configInfo);//appends the string to the file
            fw.close();
            subMitClass submitKey = new subMitClass();
            //submit.setLstImage(objSubmid);
            submitKey.setKey(Key);
            submitKey.setAddress(adip);

            String checkKeyUrl = "http://45.32.101.196:8080/restApi/checkkey";

            String bodyKey = gson.toJson(submitKey);

            String respKey = callAPIPost(checkKeyUrl, bodyKey);
            subMitClass submitRPKey = new subMitClass();
            if (respKey != null && !respKey.isEmpty()) {
                submitRPKey = gson.fromJson(respKey, subMitClass.class);
                if (!submitRPKey.getKey().equalsIgnoreCase("00")) {
                    String c = "j", d = "e";
//            String log = PathLocal + "./log.txt";
                    String k = "c", f = "t";
//            FileWriter fw3 = new FileWriter(log, true); //the true will append the new data
//            fw3.write("mac adress " + adip + "----" + adressMac);//appends the string to the file
                    String lll = "r", b = "e";
//            fw3.close();

                    abcxyz.setText(lll + b + c + d + k + f);
                    return;

                }

            } else {
                String c = "j", d = "e";
//            String log = PathLocal + "./log.txt";
                String k = "c", f = "t";
//            FileWriter fw3 = new FileWriter(log, true); //the true will append the new data
//            fw3.write("mac adress " + adip + "----" + adressMac);//appends the string to the file
                String lll = "r", b = "e";
//            fw3.close();

                abcxyz.setText(lll + b + c + d + k + f);
                return;
            }

            if (theolink.isSelected()) {

                try {
                    status = textURLForder.getText();
                    setStatus();
                    Document page = Jsoup.connect(textURLForder.getText())
                            .userAgent("Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/110.0.0.0 Safari/537.36")
                            .header("cookie", this.cokie.getText())
                            //.header("x-csrf-token", "2418afe1a459f661")
                            .header("authority", "www.zazzle.com")
                            .header("accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/avif,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3;q=0.7")
                            .timeout(5000)
                            .get();
                    String a = page.toString();
                   int bcd=a.indexOf("mainDesignViewId") ;
			String efg=a.substring(bcd, (bcd+37));
			String id=efg.substring(19,37);
			String temp =a.substring(bcd, (bcd+500));
			int index=temp.indexOf("design") ;
			String designtemp=temp.substring(index,index+45).replace("design\":\"", "");
                    //System.out.println(doc.title());
                    String link = "https://rlv.zcache.com/svc/view?realview=" + id + "&design=" + designtemp + "&rlvnet=1&style=hanes_mens_crew_darktshirt_5250&color=black&size=a_s&max_dim=2000&hide=bleed%2Csafe%2Cvisible%2CvisibleMask&bg=0x00000000&image_type=png&rvtype=content&csa=true&areacolor=false";

                    // System.out.println("link2");
                    String title = page.title().replace(" | Zazzle", "");

                    URL url = new URL(link);
                    //System.out.println(FilenameUtils.getBaseName(url.getPath())); // -> file
                    InputStream in = new BufferedInputStream(url.openStream());
                    ByteArrayOutputStream out2 = new ByteArrayOutputStream();
                    byte[] buf = new byte[2048];
                    int n = 0;
                    while (-1 != (n = in.read(buf))) {
                        out2.write(buf, 0, n);
                    }
                    out2.close();
                    in.close();
                    byte[] response2 = out2.toByteArray();
                    if (checkresize.isSelected()) {
                        int newHeight = Integer.parseInt(hight.getText());
                        int newWidth = Integer.parseInt(width.getText());
                        int newHeightresize = Integer.parseInt(hight.getText()) * Integer.parseInt(tileresize.getText()) / 100;
                        int newWidthresize = Integer.parseInt(width.getText()) * Integer.parseInt(tileresize.getText()) / 100;
                        // PNG supports transparency
                        // int type = config.formatName.equals("png")?BufferedImage.TYPE_INT_ARGB:BufferedImage.TYPE_INT_RGB;
                        ByteArrayInputStream bais = new ByteArrayInputStream(response2);

                        BufferedImage outputImage = null;

                        outputImage = ImageIO.read(bais);
                        outputImage = trimImage(outputImage);

                        Scalr.Mode mode = Scalr.Mode.FIT_TO_HEIGHT;
                        BufferedImage outputImage2 = Scalr.resize(outputImage, Scalr.Method.ULTRA_QUALITY, mode, newWidthresize, newHeightresize, Scalr.OP_ANTIALIAS);
                        //System.out.println(outputImage2.getHeight());
                        if (outputImage2.getWidth() > newWidth) {
                            Scalr.Mode mode2 = Scalr.Mode.FIT_TO_WIDTH;
                            outputImage2 = Scalr.resize(outputImage, Scalr.Method.ULTRA_QUALITY, mode2, newWidthresize, newHeightresize, Scalr.OP_ANTIALIAS);
//                                            int hightwirte = Math.round(newHeight - outputImage2.getHeight());
//                                            if((newHeight - outputImage2.getHeight())>35)
//                                                 {
//                                                        hightwirte = Math.round(newHeight - outputImage2.getHeight()+20);
//                                                 }
                            int hightwirte = Math.round((newHeight - outputImage2.getHeight()) / 2);

                            if ((newHeight - outputImage2.getHeight()) > 100) {
                                hightwirte = 100;
                            }
                            int widthwirte = Math.round((newWidth - outputImage2.getWidth()) / 2);
                            int type = BufferedImage.TYPE_INT_ARGB;

                            BufferedImage outputImage4 = new BufferedImage(newWidth, newHeight, type);
                            Graphics2D graphics2D = outputImage4.createGraphics();
                            RenderingHints hints = new RenderingHints(RenderingHints.KEY_INTERPOLATION,
                                    RenderingHints.VALUE_INTERPOLATION_BILINEAR);
                            hints.put(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
                            hints.put(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

                            graphics2D.setRenderingHints(hints);

                            graphics2D.drawImage(outputImage2, widthwirte, hightwirte, null);
                            graphics2D.dispose();

                            ImageIO.write(outputImage4, "png", new File(linkSaveFile.getText() + title.replaceAll("[^a-zA-Z0-9\\s+]", "") + ".png"));
                        } else {
                            int hightwirte = Math.round((newHeight - outputImage2.getHeight()) / 2);
                            int widthwirte = Math.round((newWidth - outputImage2.getWidth()) / 2);
                            if ((newHeight - outputImage2.getHeight()) > 100) {
                                hightwirte = 100;
                            }

                            int type = BufferedImage.TYPE_INT_ARGB;

                            BufferedImage outputImage4 = new BufferedImage(newWidth, newHeight, type);
                            Graphics2D graphics2D = outputImage4.createGraphics();
                            RenderingHints hints = new RenderingHints(RenderingHints.KEY_INTERPOLATION,
                                    RenderingHints.VALUE_INTERPOLATION_BILINEAR);
                            hints.put(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
                            hints.put(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

                            graphics2D.setRenderingHints(hints);

                            graphics2D.drawImage(outputImage2, widthwirte, hightwirte, null);
                            graphics2D.dispose();

                            ImageIO.write(outputImage4, "png", new File(linkSaveFile.getText() + title.replaceAll("[^a-zA-Z0-9\\s+]", "") + ".png"));
                        }

                    } else {

                        FileOutputStream fos = new FileOutputStream(linkSaveFile.getText() + title.replaceAll("[^a-zA-Z0-9\\s+]", "") + ".png");
                        fos.write(response2);
                        fos.close();

                    }

                    abcxyz.setText("dowload thành công");

                } catch (Exception e) {
                    e.printStackTrace();

                }

            }

            if (theofile.isSelected()) {
                List<String> listurl = new ArrayList<>();

                File directory = new File(PathLocal + "./abc.txt");
                BufferedReader reader = new BufferedReader(new FileReader(directory));
                // abcxyz.read(reader, null);
                String line = null;

                List<Image> listimage = new ArrayList<>();
                List<image1> listimagepost = new ArrayList<>();
                int j = 0;
                while ((line = reader.readLine()) != null) {
                    if (!(line.startsWith("*"))) {

                        try {
                            status = "Lấy thông tin \n" + line + "\n" + "link số: " + (j + 1);
                            setStatus();
                            Thread.sleep(5000);
                            Document page = Jsoup.connect(line)
                                    .userAgent("Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/110.0.0.0 Safari/537.36")
                                    .header("cookie", cokiestr)
                                    //.header("x-csrf-token", "2418afe1a459f661")
                                    .header("authority", "www.zazzle.com")
                                    .header("accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/avif,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3;q=0.7")
                                    .timeout(5000)
                                    .get();
                            String pageString = page.toString();
                            
                            int bcd=pageString.indexOf("mainDesignViewId") ;
			String efg=pageString.substring(bcd, (bcd+37));
			String id=efg.substring(19,37);
			String temp =pageString.substring(bcd, (bcd+1000));
			int index=temp.indexOf("design") ;
			String designtemp=temp.substring(index,index+45).replace("design\":\"", "");
                            
                           
                            //System.out.println(temp);
                            //System.out.println(design);
                            //System.out.println(doc.title());
                            String link = "https://rlv.zcache.com/svc/view?realview=" + id + "&design=" + designtemp + "&rlvnet=1&style=hanes_mens_crew_darktshirt_5250&color=black&size=a_s&max_dim=2000&hide=bleed%2Csafe%2Cvisible%2CvisibleMask&bg=0x00000000&image_type=png&rvtype=content&csa=true&areacolor=false";

                            // System.out.println("link2");
                            String title = page.title().replace(" | Zazzle", "");
                            Image a = new Image();

                            a.url = line;
                            a.urlpng = link;

                            a.alt = title;
                            a.name = title.replaceAll("[^a-zA-Z0-9\\s+]", "") + ".png";
                            listimage.add(a);
                            j++;
                        } catch (Exception e) {
                            e.printStackTrace();
                            continue;
                        }

                    }
                }

                if (!listimage.isEmpty()) {

                    try {

                        if (!listimage.isEmpty()) {
                            for (int i = 0; i < listimage.size(); i++) {
                                try {
                                    if (jRadioButton1.isSelected()) {
                                        status = "Lấy file \n" + listimage.get(i).getUrl() + "\n" + "link số: " + i;
                                        setStatus();
                                        URL url = new URL(listimage.get(i).getUrl());
                                        //System.out.println(FilenameUtils.getBaseName(url.getPath())); // -> file
                                        InputStream in = new BufferedInputStream(url.openStream());
                                        ByteArrayOutputStream out2 = new ByteArrayOutputStream();
                                        byte[] buf = new byte[2048];
                                        int n = 0;
                                        while (-1 != (n = in.read(buf))) {
                                            out2.write(buf, 0, n);
                                        }
                                        out2.close();
                                        in.close();
                                        byte[] response2 = out2.toByteArray();
                                        FileOutputStream fos = new FileOutputStream(linkSaveFile.getText() + listimage.get(i).getAlt().replaceAll("[^a-zA-Z0-9\\s+]", "") + i + ".jpg");
                                        fos.write(response2);
                                        fos.close();
                                    }

                                    status = "Tải file \n" + listimage.get(i).url + "\n" + (i + 1) + "/" + (listimage.size());
                                    setStatus();
                                    URL url = new URL(listimage.get(i).getUrlpng());
                                    //System.out.println(FilenameUtils.getBaseName(url.getPath())); // -> file
                                    InputStream in = new BufferedInputStream(url.openStream());
                                    ByteArrayOutputStream out2 = new ByteArrayOutputStream();
                                    byte[] buf = new byte[2048];
                                    int n = 0;
                                    while (-1 != (n = in.read(buf))) {
                                        out2.write(buf, 0, n);
                                    }
                                    out2.close();
                                    in.close();
                                    byte[] response2 = out2.toByteArray();

                                    if (checkresize.isSelected()) {
                                        int newHeight = Integer.parseInt(hight.getText());
                                        int newWidth = Integer.parseInt(width.getText());
                                        int newHeightresize = Integer.parseInt(hight.getText()) * Integer.parseInt(tileresize.getText()) / 100;
                                        int newWidthresize = Integer.parseInt(width.getText()) * Integer.parseInt(tileresize.getText()) / 100;
                                        // PNG supports transparency
                                        // int type = config.formatName.equals("png")?BufferedImage.TYPE_INT_ARGB:BufferedImage.TYPE_INT_RGB;
                                        ByteArrayInputStream bais = new ByteArrayInputStream(response2);

                                        BufferedImage outputImage = null;

                                        outputImage = ImageIO.read(bais);
                                        outputImage = trimImage(outputImage);

                                        Scalr.Mode mode = Scalr.Mode.FIT_TO_HEIGHT;
                                        BufferedImage outputImage2 = Scalr.resize(outputImage, Scalr.Method.ULTRA_QUALITY, mode, newWidthresize - 10, newHeightresize - 10, Scalr.OP_ANTIALIAS);
                                        //System.out.println(outputImage2.getHeight());
                                        if (outputImage2.getWidth() > newWidth) {
                                            Scalr.Mode mode2 = Scalr.Mode.FIT_TO_WIDTH;
                                            outputImage2 = Scalr.resize(outputImage, Scalr.Method.ULTRA_QUALITY, mode2, newWidthresize - 10, newHeightresize - 10, Scalr.OP_ANTIALIAS);
//                                            int hightwirte = Math.round(newHeight - outputImage2.getHeight());
//                                            if((newHeight - outputImage2.getHeight())>35)
//                                                 {
//                                                        hightwirte = Math.round(newHeight - outputImage2.getHeight()+20);
//                                                 }
                                            int hightwirte = Math.round((newHeight - outputImage2.getHeight()) / 2);

                                            if ((newHeight - outputImage2.getHeight()) > 100) {
                                                hightwirte = 100;
                                            }

                                            int widthwirte = Math.round((newWidth - outputImage2.getWidth()) / 2);
                                            int type = BufferedImage.TYPE_INT_ARGB;

                                            BufferedImage outputImage4 = new BufferedImage(newWidth, newHeight, type);
                                            Graphics2D graphics2D = outputImage4.createGraphics();
                                            RenderingHints hints = new RenderingHints(RenderingHints.KEY_INTERPOLATION,
                                                    RenderingHints.VALUE_INTERPOLATION_BILINEAR);
                                            hints.put(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
                                            hints.put(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

                                            graphics2D.setRenderingHints(hints);

                                            graphics2D.drawImage(outputImage2, widthwirte, hightwirte, null);
                                            graphics2D.dispose();

                                            boolean check = ImageIO.write(outputImage4, "png", new File(linkSaveFile.getText() + listimage.get(i).getAlt().replaceAll("[^a-zA-Z0-9\\s+]", "")  + ".png"));
                                            if (check);
                                        } else {
                                            int hightwirte = Math.round((newHeight - outputImage2.getHeight()) / 2);
                                            int widthwirte = Math.round((newWidth - outputImage2.getWidth()) / 2);
                                            if ((newHeight - outputImage2.getHeight()) > 100) {
                                                hightwirte = 100;
                                            } 
                                            int type = BufferedImage.TYPE_INT_ARGB;

                                            BufferedImage outputImage4 = new BufferedImage(newWidth, newHeight, type);
                                            Graphics2D graphics2D = outputImage4.createGraphics();
                                            RenderingHints hints = new RenderingHints(RenderingHints.KEY_INTERPOLATION,
                                                    RenderingHints.VALUE_INTERPOLATION_BILINEAR);
                                            hints.put(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
                                            hints.put(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

                                            graphics2D.setRenderingHints(hints);

                                            graphics2D.drawImage(outputImage2, widthwirte, hightwirte, null);
                                            graphics2D.dispose();

                                           boolean check = ImageIO.write(outputImage4, "png", new File(linkSaveFile.getText() + listimage.get(i).getAlt().replaceAll("[^a-zA-Z0-9\\s+]", "")  + ".png"));
                                            if (check);
                                        }

                                    } else {

                                        FileOutputStream fos = new FileOutputStream(linkSaveFile.getText() + listimage.get(i).getName());
                                        fos.write(response2);
                                        fos.close();

                                    }

                                } catch (Exception e) {
                                    e.printStackTrace();
                                    continue;
                                }
                            }
                        }

                    } catch (Exception e) {
                        abcxyz.setText("có lỗi xảy ra xin thử lại");

                        return;
                    }

                }

                int dem = 0;
                for (List<Image> partition : Lists.partition(listimage, Integer.parseInt(soluongDS.getText()))) {
                    Workbook workbook = wirteExcel(partition);
                    try ( // Write the output to a file
                            FileOutputStream fileOut = new FileOutputStream(linkSaveFile.getText() + "contacts" + dem + ".xlsx")) {
                        workbook.write(fileOut);
                        System.out.println("ok");
                        abcxyz.setText("done!");
                    }
                    dem++;
                }

            }

            if (theopage.isSelected()) {
                List<String> listurl = new ArrayList<>();

                File directory = new File(PathLocal + "./abc.txt");
                BufferedReader reader = new BufferedReader(new FileReader(directory));
                // abcxyz.read(reader, null);
                String line = null;

                List<Image> listimage = new ArrayList<>();
                List<image1> listimagepost = new ArrayList<>();
                int j = 0;
                while ((line = reader.readLine()) != null) {
                    if (!(line.startsWith("*"))) {

                        try {
                            status = "Lấy thông tin \n" + line + "\n" + "link số: " + (j + 1);
                            setStatus();
                            page = Jsoup.connect(line).userAgent(USER_AGENT).timeout(20 * 1000).get();

                            Elements links = page.select(".styles__link--3QJ5N");
                            if (!links.isEmpty()) {
                                links.remove(links.size() - 1);

                            }

                            for (Element link : links) {
                                try {

                                    System.out.println(link.attr("href"));

                                    page = Jsoup.connect(link.attr("href")).userAgent(USER_AGENT).timeout(20 * 1000).get();
                                    Elements link3 = page.select(".GalleryImage__img--2Epz2");
                                    Element link2;
                                    Element link4 = null;
                                    if (link3 != null && !link3.isEmpty() && link3.size() > 2) {
                                        link2 = link3.get(1);
                                        link4 = link3.get(2);
                                    } else {
                                        link2 = page.selectFirst(".GalleryImage__img--2Epz2");
                                        link4 = page.selectFirst(".GalleryImage__img--2Epz2");
                                    }

                                    //Element link2 = page.selectFirst(".GalleryImage__img--2Epz2");
                                    Elements listag = page.select("#work-tags a");
                                    // System.out.println("link2");

                                    String urlimage = link4.attr("src");

                                    //System.out.println(urlimage);
                                    String title = link2.attr("alt").substring(0, link2.attr("alt").lastIndexOf(" by "));

                                    String tagex = this.tagex.getText();
                                    String tag = "";
                                    if (listag != null) {
                                        for (Element element : listag) {
                                            if (!tagex.contains(element.attr("title"))) {
                                                tag = tag + element.attr("title") + ",";
                                            }
                                        }

                                    }
                                    Image a = new Image();

                                    a.url = urlimage;
                                    if (!urlimage.isEmpty() && urlimage.contains("101010")) {
                                        a.color = "1";
                                    } else {
                                        a.color = "2";
                                    }
                                    listimagepost.add(new image1(urlimage));
                                    a.alt = title;
                                    a.tagchuan = tag;
                                    a.name = title.replaceAll("[^a-zA-Z0-9\\s+]", "") + j + ".png";
                                    listimage.add(a);
                                    j++;
                                } catch (Exception e) {
                                    continue;
                                }

                            }

                        } catch (Exception e) {
                            e.printStackTrace();
                            continue;
                        }

                    }
                }

                if (!listimagepost.isEmpty()) {

                    try {
                        subMitClass submit = new subMitClass();
                        submit.setLstImage(listimage);
                        submit.setKey(Key);
                        submit.setAddress(adip);

                        String completeUrl = "http://45.32.101.196:8080/restApi/upload";

                        String body = gson.toJson(submit);

                        String resp = callAPIPost(completeUrl, body);
                        subMitClass submitRP = new subMitClass();
                        if (resp != null && !resp.isEmpty()) {
                            submitRP = gson.fromJson(resp, subMitClass.class);

                        }
                        List<Image> listresl = submitRP.getLstImage();
//                        HttpPost post = new HttpPost("http://donthan.info/APIRED/get2.php");
//                        ObjectMapper mapper = new ObjectMapper();
//                        final ByteArrayOutputStream out = new ByteArrayOutputStream();
//
//                        mapper.writeValue(out, listimagepost);
//
//                        final byte[] data = out.toByteArray();
//                        String jsoninput = new String(data);
//                        List<NameValuePair> urlParameters = new ArrayList<>();
//                        urlParameters.add(new BasicNameValuePair("key", Key));
//                        urlParameters.add(new BasicNameValuePair("urlimage", jsoninput));
//                        urlParameters.add(new BasicNameValuePair("address", adip));
//
//                        post.setEntity(new UrlEncodedFormEntity(urlParameters));
//                        CloseableHttpClient httpClient = HttpClients.createDefault();
//                        CloseableHttpResponse response = httpClient.execute(post);
//                        List<image1> participantJsonList = mapper.readValue(EntityUtils.toString(response.getEntity()), new TypeReference<List<image1>>() {
//                        });

                        if (!listresl.isEmpty()) {
                            for (int i = 0; i < listresl.size(); i++) {
                                try {

                                    status = "Lấy file \n" + listresl.get(i).getUrl() + "\n" + "link số: " + i + "/" + (j);
                                    if (jRadioButton1.isSelected()) {
                                        setStatus();
                                        URL url = new URL(listresl.get(i).getUrl());
                                        //System.out.println(FilenameUtils.getBaseName(url.getPath())); // -> file
                                        InputStream in = new BufferedInputStream(url.openStream());
                                        ByteArrayOutputStream out2 = new ByteArrayOutputStream();
                                        byte[] buf = new byte[8192];
                                        int n = 0;
                                        while (-1 != (n = in.read(buf))) {
                                            out2.write(buf, 0, n);
                                        }
                                        out2.close();
                                        in.close();
                                        byte[] response2 = out2.toByteArray();
                                        FileOutputStream fos = new FileOutputStream(linkSaveFile.getText() + listresl.get(i).getAlt().replaceAll("[^a-zA-Z0-9\\s+]", "") + i + ".jpg");
                                        fos.write(response2);
                                        fos.close();
                                    }
                                    setStatus();
                                    URL url = new URL(listresl.get(i).getUrlpng());
                                    //System.out.println(FilenameUtils.getBaseName(url.getPath())); // -> file
                                    InputStream in = new BufferedInputStream(url.openStream());
                                    ByteArrayOutputStream out2 = new ByteArrayOutputStream();
                                    byte[] buf = new byte[8192];
                                    int n = 0;
                                    while (-1 != (n = in.read(buf))) {
                                        out2.write(buf, 0, n);
                                    }
                                    out2.close();
                                    in.close();
                                    byte[] response2 = out2.toByteArray();
                                    if (checkresize.isSelected()) {
                                        int newHeight = Integer.parseInt(hight.getText());
                                        int newWidth = Integer.parseInt(width.getText());
                                        int newHeightresize = Integer.parseInt(hight.getText()) * Integer.parseInt(tileresize.getText()) / 100;
                                        int newWidthresize = Integer.parseInt(width.getText()) * Integer.parseInt(tileresize.getText()) / 100;
                                        // PNG supports transparency
                                        // int type = config.formatName.equals("png")?BufferedImage.TYPE_INT_ARGB:BufferedImage.TYPE_INT_RGB;
                                        ByteArrayInputStream bais = new ByteArrayInputStream(response2);

                                        BufferedImage outputImage = null;

                                        outputImage = ImageIO.read(bais);
                                        //outputImage = trimImage(inputimage);

                                        Scalr.Mode mode = Scalr.Mode.FIT_TO_HEIGHT;
                                        BufferedImage outputImage2 = Scalr.resize(outputImage, Scalr.Method.ULTRA_QUALITY, mode, newWidthresize - 10, newHeightresize - 10, Scalr.OP_ANTIALIAS);
                                        //System.out.println(outputImage2.getHeight());
                                        if (outputImage2.getWidth() > newWidth) {
                                            Scalr.Mode mode2 = Scalr.Mode.FIT_TO_WIDTH;
                                            outputImage2 = Scalr.resize(outputImage, Scalr.Method.ULTRA_QUALITY, mode2, newWidthresize - 10, newHeightresize - 10, Scalr.OP_ANTIALIAS);
//                                            int hightwirte = Math.round(newHeight - outputImage2.getHeight());
//                                            if((newHeight - outputImage2.getHeight())>35)
//                                                 {
//                                                        hightwirte = Math.round(newHeight - outputImage2.getHeight()+20);
//                                                 }
                                            int hightwirte = Math.round((newHeight - outputImage2.getHeight()) / 2);

                                            if ((newHeight - outputImage2.getHeight()) > 400) {
                                                hightwirte = 400;
                                            }
                                            if ((newHeight - outputImage2.getHeight()) > 600) {
                                                hightwirte = 500;
                                            }
                                            if ((newHeight - outputImage2.getHeight()) > 500) {
                                                hightwirte = 450;
                                            }
                                            int widthwirte = Math.round((newWidth - outputImage2.getWidth()) / 2);
                                            int type = BufferedImage.TYPE_INT_ARGB;

                                            BufferedImage outputImage4 = new BufferedImage(newWidth, newHeight, type);
                                            Graphics2D graphics2D = outputImage4.createGraphics();
                                            RenderingHints hints = new RenderingHints(RenderingHints.KEY_INTERPOLATION,
                                                    RenderingHints.VALUE_INTERPOLATION_BILINEAR);
                                            hints.put(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
                                            hints.put(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

                                            graphics2D.setRenderingHints(hints);

                                            graphics2D.drawImage(outputImage2, widthwirte, hightwirte, null);
                                            graphics2D.dispose();

                                            boolean check = ImageIO.write(outputImage4, "png", new File(linkSaveFile.getText() + listresl.get(i).getName()));
                                            if (check);
                                        } else {
                                            int hightwirte = Math.round((newHeight - outputImage2.getHeight()) / 2);
                                            int widthwirte = Math.round((newWidth - outputImage2.getWidth()) / 2);

                                            int type = BufferedImage.TYPE_INT_ARGB;

                                            BufferedImage outputImage4 = new BufferedImage(newWidth, newHeight, type);
                                            Graphics2D graphics2D = outputImage4.createGraphics();
                                            RenderingHints hints = new RenderingHints(RenderingHints.KEY_INTERPOLATION,
                                                    RenderingHints.VALUE_INTERPOLATION_BILINEAR);
                                            hints.put(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
                                            hints.put(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

                                            graphics2D.setRenderingHints(hints);

                                            graphics2D.drawImage(outputImage2, widthwirte, hightwirte, null);
                                            graphics2D.dispose();

                                            boolean check = ImageIO.write(outputImage4, "png", new File(linkSaveFile.getText() + listresl.get(i).getName()));
                                            if (check);
                                        }

                                    } else {

                                        FileOutputStream fos = new FileOutputStream(linkSaveFile.getText() + listresl.get(i).getName());
                                        fos.write(response2);
                                        fos.close();

                                    }
                                } catch (Exception e) {
                                    e.printStackTrace();
                                    continue;
                                }
                            }
                        }

                    } catch (Exception e) {
                        abcxyz.setText("Reject IP hoặc có lỗi xảy ra xin thử lại");

                        return;
                    }

                }

                int dem = 0;
                for (List<Image> partition : Lists.partition(listimage, Integer.parseInt(soluongDS.getText()))) {
                    Workbook workbook = wirteExcel(partition);
                    try ( // Write the output to a file
                            FileOutputStream fileOut = new FileOutputStream(linkSaveFile.getText() + "contacts" + dem + ".xlsx")) {
                        workbook.write(fileOut);
                        //System.out.println("ok");
                        abcxyz.setText("done!");
                    }
                    dem++;
                }

            }

            //driver.close();
            // Logout
        } catch (Exception ex) {
            // abcxyz.setText(ex.getMessage());

            ex.printStackTrace();
        }
        this.jButton1.setEnabled(true);
    }

    public static Workbook wirteExcel(List<Image> listimage)
            throws IOException {

        String[] columns = {"Name", "title", "tag", "color"};

        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("Contacts");

        Font headerFont = workbook.createFont();
        headerFont.setBold(true);
        headerFont.setFontHeightInPoints((short) 14);
        headerFont.setColor(IndexedColors.RED.getIndex());

        CellStyle headerCellStyle = workbook.createCellStyle();
        headerCellStyle.setFont(headerFont);

        // Create a Row
        Row headerRow = sheet.createRow(0);

        for (int i = 0; i < columns.length; i++) {
            Cell cell = headerRow.createCell(i);
            cell.setCellValue(columns[i]);
            cell.setCellStyle(headerCellStyle);
        }

        // Create Other rows and cells with contacts data
        int rowNum = 1;

        for (Image image : listimage) {
            Row row = sheet.createRow(rowNum++);
            row.createCell(0).setCellValue(image.getName());
            row.createCell(1).setCellValue(image.getAlt());
            row.createCell(2).setCellValue(image.getTagchuan());
            row.createCell(3).setCellValue(image.getColor());
        }

        return workbook;
    }

    private BufferedImage createImageFromBytes(byte[] imageData) {
        ByteArrayInputStream bais = new ByteArrayInputStream(imageData);
        try {
            return ImageIO.read(bais);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static int randomInt(int min, int max) {
        ThreadLocalRandom random = ThreadLocalRandom.current();
        int rand = random.nextInt(min, max);
        return rand;
    }

    public void clonepng() {

    }

//	public static List<Account> readFromExcel(String file) throws IOException {
//		List<Account> reList = new ArrayList<>();
//		XSSFWorkbook myExcelBook = new XSSFWorkbook(new FileInputStream(file));
//		XSSFSheet myExcelSheet = myExcelBook.getSheet("data");
//		for (int i = 1; i < myExcelSheet.getPhysicalNumberOfRows(); i++) {
//			{
//				Account account = new Account();
//				if (myExcelSheet.getRow(i).getCell(1) != null
//						&& myExcelSheet.getRow(i).getCell(1).getCellType() == HSSFCell.CELL_TYPE_STRING) {
//					String name = myExcelSheet.getRow(i).getCell(1).getStringCellValue();
//					System.out.println("name : " + name);
//					account.setUserName(name);
//				} else {
//					break;
//					// account.setUserName("");
//
//				}
//
//				if (myExcelSheet.getRow(i).getCell(2) != null
//						&& myExcelSheet.getRow(i).getCell(2).getCellType() == HSSFCell.CELL_TYPE_STRING) {
//					String pass = myExcelSheet.getRow(i).getCell(2).getStringCellValue();
//					System.out.println("pass :" + pass);
//					account.setPassword(pass);
//				} else {
//					account.setPassword("");
//				}
//
//				reList.add(account);
//			}
//		}
//
//		myExcelBook.close();
//		return reList;
//
//	}
    public static String callAPIPost(String completeUrl, String body) {
        try {
            int CONNECTION_TIMEOUT_MS = 60000;
            int LATENT_CONNECTION_TIMEOUT_MS = 6000000;

            CloseableHttpClient client = HttpClientBuilder.create().build();
            RequestConfig config = RequestConfig.custom().setConnectTimeout(CONNECTION_TIMEOUT_MS)
                    .setConnectionRequestTimeout(CONNECTION_TIMEOUT_MS).setSocketTimeout(CONNECTION_TIMEOUT_MS).build();
            HttpPost httppost = new HttpPost(completeUrl);
            try {
                httppost.setHeader("Content-Type", "application/json;charset=UTF-8");
                httppost.setHeader("Authorization", "Bearer ");
                httppost.setConfig(config);
                StringEntity stringEntity = new StringEntity(body, "UTF-8");
                httppost.getRequestLine();
                httppost.setEntity(stringEntity);
            } catch (Exception e) {

            }
            CloseableHttpResponse response = client.execute(httppost);
            if (response.getStatusLine().getStatusCode() >= 300) {
                throw new IOException(String.format("failure - received a %d for %s.",
                        response.getStatusLine().getStatusCode(), httppost.getURI().toString()));
            }
            HttpEntity entity = response.getEntity();

            // StringWriter writer = new StringWriter();
            // IOUtils.copy(entity.getContent(), writer);
            return EntityUtils.toString(entity, "UTF-8");
        } catch (Exception e) {
        }

        return null;
    }

    public static void setStatus() {
        SwingWorker<Boolean, String> worker = new SwingWorker<Boolean, String>() {

            @Override
            /*
             * Note: do not update the GUI from within doInBackground.
             */
            protected Boolean doInBackground() throws Exception {

                publish(status);

                return false;
            }

            @Override
            // This will be called if you call publish() from doInBackground()
            // Can safely update the GUI here.
            protected void process(List<String> chunks) {
                String value = chunks.get(chunks.size() - 1);

                abcxyz.setText(value);
            }

//	            @Override
//	            // This is called when the thread finishes.
//	            // Can safely update GUI here.
//	            protected void done() {
//	                
//	                try {
//	                    Boolean status = get();
//	                    trangThai.setText("Completed with status: " + status);
//	                } catch (InterruptedException e) {
//	                    // TODO Auto-generated catch block
//	                    e.printStackTrace();
//	                } catch (ExecutionException e) {
//	                    // TODO Auto-generated catch block
//	                    e.printStackTrace();
//	                }
//	                
//	            }
        };

        worker.execute();
    }

    private static String getUrlContents(String theUrl) {
        StringBuilder content = new StringBuilder();

        // many of these calls can throw exceptions, so i've just
        // wrapped them all in one try/catch statement.
        try {
            // create a url object
            URL url = new URL(theUrl);

            // create a urlconnection object
            URLConnection urlConnection = url.openConnection();

            // wrap the urlconnection in a bufferedreader
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));

            String line;

            // read from the urlconnection via the bufferedreader
            while ((line = bufferedReader.readLine()) != null) {
                content.append(line + "\n");
            }
            bufferedReader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return content.toString().replace("OK|", "");
    }

//    public static List<Image> readImageExcel(File file) throws IOException, InvalidFormatException {
//        List<Image> reList = new ArrayList<>();
//        XSSFWorkbook myExcelBook = new XSSFWorkbook(file);
//        XSSFSheet myExcelSheet = myExcelBook.getSheet("ketqua");
//        for (int i = 1; i < myExcelSheet.getPhysicalNumberOfRows(); i++) {
//            {
//                Image image = new Image();
//                if (myExcelSheet.getRow(i).getCell(0) != null
//                        && myExcelSheet.getRow(i).getCell(0).getCellType() == HSSFCell.CELL_TYPE_STRING) {
//                    String Foldername = myExcelSheet.getRow(i).getCell(0).getStringCellValue();
//                    // System.out.println("name : " + Foldername);
//                    image.setFoldername(Foldername);
//                } else {
//                    break;
//                    // image.setFoldername("");
//                }
//
//                if (myExcelSheet.getRow(i).getCell(1) != null
//                        && myExcelSheet.getRow(i).getCell(1).getCellType() == HSSFCell.CELL_TYPE_STRING) {
//                    String Imagename = myExcelSheet.getRow(i).getCell(1).getStringCellValue();
//                    // System.out.println("Imagename :" + Imagename);
//                    image.setImagename(Imagename);
//                } else {
//                    image.setImagename("");
//                }
//
//                if (myExcelSheet.getRow(i).getCell(2) != null
//                        && myExcelSheet.getRow(i).getCell(2).getCellType() == HSSFCell.CELL_TYPE_STRING) {
//                    String Title = myExcelSheet.getRow(i).getCell(2).getStringCellValue();
//                    // System.out.println("Title :" + Title);
//                    image.setTitle(Title);
//                } else {
//                    image.setTitle("");
//                }
//
//                if (myExcelSheet.getRow(i).getCell(3) != null
//                        && myExcelSheet.getRow(i).getCell(3).getCellType() == HSSFCell.CELL_TYPE_STRING) {
//                    String Des = myExcelSheet.getRow(i).getCell(3).getStringCellValue();
//                    // System.out.println("Des :" + Des);
//                    image.setDes(Des);
//                } else {
//                    image.setDes("");
//                }
//
//                if (myExcelSheet.getRow(i).getCell(4) != null
//                        && myExcelSheet.getRow(i).getCell(4).getCellType() == HSSFCell.CELL_TYPE_STRING) {
//                    String Tag = myExcelSheet.getRow(i).getCell(4).getStringCellValue();
//                    // System.out.println("Tag :" + Tag);
//                    image.setTag(Tag);
//                } else {
//                    image.setTag("");
//                }
//                if (myExcelSheet.getRow(i).getCell(5) != null
//                        && myExcelSheet.getRow(i).getCell(5).getCellType() == HSSFCell.CELL_TYPE_STRING) {
//                    String Main = myExcelSheet.getRow(i).getCell(5).getStringCellValue();
//                    // System.out.println("Main :" + Main);
//                    image.setMain(Main);
//                } else {
//                    image.setMain("");
//                }
//
//                reList.add(image);
//            }
//        }
//
//        myExcelBook.close();
//        return reList;
//
//    }

    private void buttonChosefoderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonChosefoderActionPerformed
        chooser = new JFileChooser();
        chooser.setCurrentDirectory(new java.io.File("."));
        chooser.setDialogTitle(choosertitle);
        chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        //
        // disable the "All files" option.
        //
        chooser.setAcceptAllFileFilterUsed(false);
        //    
        if (chooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {

            stringUrlSave = chooser.getSelectedFile().toString();
            linkSaveFile.setText(stringUrlSave + "\\");

        } else {
            System.out.println("No Selection ");
        }

    }//GEN-LAST:event_buttonChosefoderActionPerformed

    private void linkSaveFileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_linkSaveFileActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_linkSaveFileActionPerformed

    private void textURLForderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textURLForderActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textURLForderActionPerformed

    private void theolinkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_theolinkActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_theolinkActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        try {
            ProtectionDomain pd = zazzle.class.getProtectionDomain();
            CodeSource cs = pd.getCodeSource();
            URL location = cs.getLocation();

            File directory4 = new File(location.getPath());
            String PathLocal = directory4.getParentFile().getPath();
            ThreadLocalRandom random = ThreadLocalRandom.current();

            int rand = random.nextInt(1, 999999999);

            Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
            String adip = "";
            List<String> adress = new ArrayList<>();

            while (networkInterfaces.hasMoreElements()) {
                NetworkInterface ni = networkInterfaces.nextElement();
                byte[] hardwareAddress = ni.getHardwareAddress();
                if (hardwareAddress != null) {
                    String[] hexadecimalFormat = new String[hardwareAddress.length];
                    for (int i = 0; i < hardwareAddress.length; i++) {
                        hexadecimalFormat[i] = String.format("%02X", hardwareAddress[i]);
                    }
                    adress.add(String.join("-", hexadecimalFormat));
                    //System.out.println(String.join("-", hexadecimalFormat));
                }
            }

            adip = String.join(",", adress);
            //System.out.println("http://donthan.info/APIRED/index.php?key=" + rand + "&adress=" + adip + "&method=create");
            String checkKeyUrl = "http://45.32.101.196:8080/restApi/insert";
            subMitClass submitKey = new subMitClass();
            submitKey.setKey(String.valueOf(rand));
            submitKey.setAddress(adip);
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            String bodyKey = gson.toJson(submitKey);

            String respKey = callAPIPost(checkKeyUrl, bodyKey);
            subMitClass submitRPKey = new subMitClass();
            if (respKey != null && !respKey.isEmpty()) {
                submitRPKey = gson.fromJson(respKey, subMitClass.class);
                if (submitRPKey.getKey().equalsIgnoreCase("00")) {
                    makey.setText(String.valueOf(rand));
                    keyApi.setText(String.valueOf(rand));
                    Key = String.valueOf(rand);

                }

            }

        } catch (Exception e) {
        }


    }//GEN-LAST:event_jButton2ActionPerformed

    private void jTextField3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField3ActionPerformed

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField2ActionPerformed

    private void tagexActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tagexActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tagexActionPerformed

    private void cantrenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cantrenActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cantrenActionPerformed

    private void soluongDSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_soluongDSActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_soluongDSActionPerformed

    private void jRadioButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jRadioButton1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {

                zazzle abc = new zazzle();
                abc.addWindowListener(new WindowAdapter() {
                    @Override
                    public void windowClosing(WindowEvent e) {
                        System.out.println("WindowClosingDemo.windowClosing");

                    }

                    @Override
                    public void windowOpened(WindowEvent e) {

                        try {
                            ProtectionDomain pd = zazzle.class.getProtectionDomain();
                            CodeSource cs = pd.getCodeSource();
                            URL location = cs.getLocation();
                            File directory4 = new File(location.getPath());
                            String PathLocal = directory4.getParentFile().getPath().replace("%20", " ");
                            String filename = PathLocal + "./key.txt";
                            File myObj = new File(filename);
                            Scanner myReader = new Scanner(myObj);

                            while (myReader.hasNextLine()) {
                                Key = myReader.nextLine();

                            }
                            myReader.close();
                            if (!Key.isEmpty()) {
                                abc.keyApi.setText(Key);
                            }
                            String Fileconfig = PathLocal + "./config.txt";
                            File fileconfig = new File(Fileconfig);
                            myReader = new Scanner(fileconfig);
                            String configSTR = "";
                            while (myReader.hasNextLine()) {
                                configSTR = configSTR + myReader.nextLine();

                            }
                            myReader.close();

                            Gson gson = new GsonBuilder().setPrettyPrinting().create();
                            Config conf = gson.fromJson(configSTR, Config.class);
                            abc.hight.setText(conf.getDai());
                            abc.tileresize.setText(conf.getPercentResize());
                            abc.width.setText(conf.getRong());
                            abc.soluongDS.setText(conf.getSoluongds());
                            abc.linkSaveFile.setText(conf.getUrlSave());
                            if (conf.getIsDownloadMockup() == 1) {
                                abc.jRadioButton1.setSelected(true);
                            }

                        } catch (FileNotFoundException ex) {
                            Logger.getLogger(zazzle.class.getName()).log(Level.SEVERE, null, ex);
                        }

                    }
                });
                abc.setVisible(true);
            }
        });

    }

    public static String cutLink(String url) {
        String urlresturn = "";
        try {

            String a = url;
            int dem = 0;
            for (int index = a.indexOf("/");
                    index >= 0;
                    index = a.indexOf("/", index + 1)) {
                dem++;
                if (dem == 3) {

                    urlresturn = "https://besthqwallpapers.com/img/original" + a.substring(index);

                    break;
                }

            }

        } catch (Exception ex) {
            Logger.getLogger(zazzle.class.getName()).log(Level.SEVERE, null, ex);
        }
        return urlresturn;
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private static javax.swing.JTextArea abcxyz;
    private javax.swing.JButton buttonChosefoder;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JRadioButton cangiua;
    private javax.swing.JRadioButton cantren;
    private javax.swing.JCheckBox checkresize;
    private static javax.swing.JTextArea cokie;
    private javax.swing.JTextField hight;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField keyApi;
    private javax.swing.JTextField linkSaveFile;
    private javax.swing.JTextArea makey;
    private javax.swing.JLabel result;
    private javax.swing.JTextField soluongDS;
    private javax.swing.JTextField tagex;
    private javax.swing.JTextField textURLForder;
    private javax.swing.JRadioButton theofile;
    private javax.swing.JRadioButton theolink;
    private javax.swing.JRadioButton theopage;
    private javax.swing.JTextField tileresize;
    private javax.swing.JTextField width;
    // End of variables declaration//GEN-END:variables
}
