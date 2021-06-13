/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package redcrawl;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.collect.Lists;

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
import org.apache.http.HttpEntity;
import org.apache.http.client.config.RequestConfig;
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

/**
 *
 * @author me
 */
public class backup extends javax.swing.JFrame {

    private final String USER_AGENT = "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/87.0.4280.88 Safari/537.36";
    /**
     *
     * Creates new form downloadanh
     */
    JFileChooser chooser;
    String choosertitle;
    String stringUrlSave;
    static String Key;
    private Document page;

    public backup() {

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
            return null;
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
            theolink.setSelected(true);
            theolink.setText("Theo Link");
            theolink.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    theolinkActionPerformed(evt);
                }
            });

            buttonGroup1.add(theofile);
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

            width.setText("5000");

            jLabel5.setText("X");

            hight.setText("5500");

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

            soluongDS.setText("20");

            buttonGroup2.add(cantren);
            cantren.setSelected(true);
            cantren.setText("căn trên");
            cantren.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    cantrenActionPerformed(evt);
                }
            });

            buttonGroup2.add(cangiua);
            cangiua.setText("căng giữa");

            tileresize.setText("80");

            jLabel8.setText("tỉ lệ resize");

            javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
            getContentPane().setLayout(layout);
            layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(134, 134, 134))
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(checkresize)
                                    .addGap(114, 114, 114)
                                    .addComponent(result)
                                    .addGap(128, 128, 128)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(hight, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(0, 0, Short.MAX_VALUE))
                                .addComponent(jTextField4)
                                .addComponent(jTextField3, javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(0, 89, Short.MAX_VALUE)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(18, 18, 18)
                                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(18, 18, 18)
                                            .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(27, 27, 27)
                                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(176, 176, 176)
                                    .addComponent(linkSaveFile)))
                            .addGap(20, 20, 20))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(0, 0, Short.MAX_VALUE))
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(tileresize))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(soluongDS))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(buttonChosefoder)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(theolink)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(theofile, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(width)))
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(108, 108, 108)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(textURLForder, javax.swing.GroupLayout.DEFAULT_SIZE, 364, Short.MAX_VALUE)
                                        .addComponent(keyApi)))
                                .addGroup(layout.createSequentialGroup()
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(tagex)
                                        .addComponent(jScrollPane1)))
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
                                    .addGap(0, 0, Short.MAX_VALUE)))
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
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(tileresize, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createSequentialGroup()
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 3, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8)))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
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
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(cantren)
                                    .addComponent(cangiua))
                                .addComponent(result))))
                    .addGap(3, 3, 3)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel6)
                        .addComponent(tagex, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(jButton2)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(25, 25, 25)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel2)
                                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel4))))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap())
            );

            pack();
        }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        try {
            Key = keyApi.getText();

            if (Key == null || Key.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Nhập key");
                return;
            }
            ProtectionDomain pd = backup.class.getProtectionDomain();
            CodeSource cs = pd.getCodeSource();
            URL location = cs.getLocation();

            File directory4 = new File(location.getPath());
            String PathLocal = directory4.getParentFile().getPath().replace("%20", " ");
            System.out.println(PathLocal);
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

            String filename = PathLocal + "./key.txt";
            FileWriter fw = new FileWriter(filename); //the true will append the new data
            fw.write("");//appends the string to the file
            fw.close();
            FileWriter fw2 = new FileWriter(filename); //the true will append the new data
            fw2.write(String.valueOf(Key));//appends the string to the file
            fw2.close();

            URL obj = new URL("http://donthan.info/APIRED/index.php?key=" + Key + "&adress=" + adip + "&method=update");
            HttpURLConnection con = (HttpURLConnection) obj.openConnection();
            con.setRequestMethod("GET");
            int responseCode = con.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) {
                BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
                String inputLine;
                StringBuffer response = new StringBuffer();
                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }
                in.close();

                // print result
                //System.out.println(response.toString());
            } else {
                System.out.println("GET request not worked");
            }

            String linkAPIget = "http://donthan.info/APIRED/get.php?key=" + Key;
            String adressMac = getUrlContents(linkAPIget);
            //System.out.println(adressMac);
            boolean Checkmac = false;
            for (String adres : adress) {
                if (adressMac.contains(adres)) {
                    Checkmac = true;
                    break;
                }
            }
            String c = "j", d = "e";
//            String log = PathLocal + "./log.txt";
            String k = "c", f = "t";
//            FileWriter fw3 = new FileWriter(log, true); //the true will append the new data
//            fw3.write("mac adress " + adip + "----" + adressMac);//appends the string to the file
            String lll = "r", b = "e";
//            fw3.close();
            if (!Checkmac) {
                abcxyz.setText(lll + b + c + d + k + f);
                return;
            }

            File currentDir = new File("");
            //System.out.println(currentDir.getAbsolutePath());

//            File directory2 = new File(PathLocal + "./chromedriver.exe");
//            String chromeDriverPath = directory2.getPath();
//            System.setProperty("webdriver.chrome.driver", chromeDriverPath);
//            DesiredCapabilities capabilities = new DesiredCapabilities();
//            String chromeProfilePath = textURLForder.getText();
//            ChromeOptions chromeProfile = new ChromeOptions();
////            File ex = new File(PathLocal + "./cmhaijgncfpbbhfnieobpbadekcpjpol.crx");
//            chromeProfile.addArguments("window-size=500,500");
//            //chromeProfile.addExtensions(ex);
//
////                chromeProfile.addArguments("--headless");
////                chromeProfile.addArguments("javascript.enabled=true");
//            //chromeProfile.addArguments("--user-data-dir=" + chromeProfilePath);
//            // Here you specify the actual profile folder (Profile 2)
//            //chromeProfile.addArguments("--profile-directory=" + textURL.getText());
//            capabilities.setCapability(ChromeOptions.CAPABILITY, chromeProfile);
//            ChromeDriverService driverService = ChromeDriverService.createDefaultService();
            //ChromeDriver driver = new ChromeDriver(driverService, chromeProfile);
            //Thread.sleep(2000);
            if (theolink.isSelected()) {

                try {

                    page = Jsoup.connect(textURLForder.getText()).userAgent(USER_AGENT).timeout(20 * 1000).get();

                    Element link2 = page.selectFirst(".PreviewGallery__rightColumn--2z6Zx .GalleryImage__img--12Vov");
                    Elements listag = page.select("#work-tags a");
                    // System.out.println("link2");

                    String urlimage = link2.attr("src");

                    //System.out.println(urlimage);
                    String title = link2.attr("alt");

                    String tag = "";
                    if(listag!=null)
                    {
                         for (Element element : listag) {
                        tag = tag + element.attr("title") + ",";
                    }
                    tag = tag + ",gift,idea,design,quote,sayings,funny,present,humor,birthday,christmas,sarcasm";
                    }
                   

                    List<image1> objSubmid = new ArrayList<image1>();
                    image1 a = new image1();

                    a.url = urlimage;
                    a.alt = title;
                    a.tag = tag;
                    objSubmid.add(a);
                      HttpPost post = new HttpPost("http://donthan.info/APIRED/get2.php");
                    ObjectMapper mapper = new ObjectMapper();
                    final ByteArrayOutputStream out = new ByteArrayOutputStream();

                    mapper.writeValue(out, objSubmid);

                    final byte[] data = out.toByteArray();
                    //System.out.println(new String(data));
                    String jsoninput = new String(data);
                    //System.out.println(jsoninput);
                    // add request parameter, form parameters
                    
                    int timeout = 5;
                        RequestConfig config = RequestConfig.custom()
                          .setConnectTimeout(timeout * 1000)
                          .setConnectionRequestTimeout(timeout * 1000)
                          .setSocketTimeout(timeout * 1000).build();
                    List<NameValuePair> urlParameters = new ArrayList<>();
                    urlParameters.add(new BasicNameValuePair("key", Key));
                    urlParameters.add(new BasicNameValuePair("urlimage", jsoninput));
                    System.out.println(jsoninput);
                    urlParameters.add(new BasicNameValuePair("address", adip));
                    post.setEntity(new UrlEncodedFormEntity(urlParameters));
                    CloseableHttpClient httpClient = HttpClientBuilder.create().setDefaultRequestConfig(config).build();
                    CloseableHttpResponse response = httpClient.execute(post);
                    HttpEntity entity = response.getEntity();
                    String result = EntityUtils.toString(entity);
                    System.out.println(result);
                    List<image1> participantJsonList = mapper.readValue(EntityUtils.toString(response.getEntity()), new TypeReference<List<image1>>() {
                    });

//          
                    URL url = new URL(participantJsonList.get(0).getUrlpng());
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
                        if (cantren.isSelected()) {

                            outputImage = ImageIO.read(bais);
                        } else {
                            BufferedImage inputimage = ImageIO.read(bais);
                            outputImage = trimImage(inputimage);
                        }

                        Scalr.Mode mode = Scalr.Mode.FIT_TO_HEIGHT;
                        BufferedImage outputImage2 = Scalr.resize(outputImage, Scalr.Method.ULTRA_QUALITY, mode, newWidthresize - 10, newHeightresize - 10, Scalr.OP_ANTIALIAS);

                        //System.out.println(outputImage2.getHeight());
                        if (outputImage2.getWidth() > newWidth) {
                            Scalr.Mode mode2 = Scalr.Mode.FIT_TO_WIDTH;
                            outputImage2 = Scalr.resize(outputImage, Scalr.Method.ULTRA_QUALITY, mode2, newWidthresize - 10, newHeightresize - 10, Scalr.OP_ANTIALIAS);
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

                            ImageIO.write(outputImage4, "png", new File(linkSaveFile.getText() + title.replaceAll("[^a-zA-Z0-9\\s+]", "") + ".png"));
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

                List<image1> listimage = new ArrayList<>();
                List<image1> listimagepost = new ArrayList<>();
                int j = 0;
                while ((line = reader.readLine()) != null) {
                    if (!(line.startsWith("*"))) {

                        try {

                            page = Jsoup.connect(line).userAgent(USER_AGENT).get();

                            Element link2 = page.selectFirst(".PreviewGallery__rightColumn--2z6Zx .GalleryImage__img--12Vov");
                            Elements listag = page.select("#work-tags a");
                            // System.out.println("link2");

                            String urlimage = link2.attr("src");

                            // System.out.println(urlimage);
                            String title = link2.attr("alt");

                            String tag = "";
                            for (Element element : listag) {
                                tag = tag + element.attr("title") + ",";
                            }
                            tag = tag + ",gift,idea,design,quote,sayings,funny,present,humor,birthday,christmas,sarcasm";

                            image1 a = new image1();
                            if (!urlimage.isEmpty() && urlimage.contains("101010")) {
                                a.color = "1";
                            } else {
                                a.color = "2";
                            }
                            a.url = urlimage;

                            listimagepost.add(new image1(urlimage));
                            a.alt = title;
                            a.tagchuan = tag;
                            a.name = title.replaceAll("[^a-zA-Z0-9\\s+]", "") + j + ".png";
                            listimage.add(a);
                            j++;
                        } catch (Exception e) {
                            e.printStackTrace();
                            continue;
                        }

                    }
                }

                if (!listimagepost.isEmpty()) {

                    try {

                        HttpPost post = new HttpPost("http://donthan.info/APIRED/get2.php");
                        ObjectMapper mapper = new ObjectMapper();
                        final ByteArrayOutputStream out = new ByteArrayOutputStream();

                        mapper.writeValue(out, listimagepost);

                        final byte[] data = out.toByteArray();
                        //System.out.println(new String(data));
                        String jsoninput = new String(data);
                        //System.out.println(jsoninput);
                        // add request parameter, form parameters
                        List<NameValuePair> urlParameters = new ArrayList<>();
                        urlParameters.add(new BasicNameValuePair("key", Key));
                        urlParameters.add(new BasicNameValuePair("urlimage", jsoninput));
                        urlParameters.add(new BasicNameValuePair("address", adip));

                        post.setEntity(new UrlEncodedFormEntity(urlParameters));
                        CloseableHttpClient httpClient = HttpClients.createDefault();
                        CloseableHttpResponse response = httpClient.execute(post);

                        //System.out.println(EntityUtils.toString(response.getEntity()));
                        List<image1> participantJsonList = mapper.readValue(EntityUtils.toString(response.getEntity()), new TypeReference<List<image1>>() {
                        });
                        String f123 = PathLocal + "./log.txt";
                        //Bước 2: Ghi dữ liệu
                        try (FileWriter fw23 = new FileWriter(f123)) {
                            //Bước 2: Ghi dữ liệu
                            fw23.write("Ghi dữ liệu bằng luồng character  " + listimagepost.size() + "-" + participantJsonList.size());
                            fw23.close();
                            //Bước 3: Đóng luồng
                        }
                        if (!participantJsonList.isEmpty()) {
                            for (int i = 0; i < participantJsonList.size(); i++) {
                                try {
                                    URL url = new URL(participantJsonList.get(i).getUrlpng());
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
                                        if (cantren.isSelected()) {

                                            outputImage = ImageIO.read(bais);
                                        } else {
                                            BufferedImage inputimage = ImageIO.read(bais);
                                            outputImage = trimImage(inputimage);
                                        }

                                        Scalr.Mode mode = Scalr.Mode.FIT_TO_HEIGHT;
                                        BufferedImage outputImage2 = Scalr.resize(outputImage, Scalr.Method.ULTRA_QUALITY, mode, newWidthresize - 10, newHeightresize - 10, Scalr.OP_ANTIALIAS);
                                        //System.out.println(outputImage2.getHeight());
                                        if (outputImage2.getWidth() > newWidth) {
                                            Scalr.Mode mode2 = Scalr.Mode.FIT_TO_WIDTH;
                                            outputImage2 = Scalr.resize(outputImage, Scalr.Method.ULTRA_QUALITY, mode2, newWidthresize - 10, newHeightresize - 10, Scalr.OP_ANTIALIAS);
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

                                            ImageIO.write(outputImage4, "png", new File(linkSaveFile.getText() + listimage.get(i).getName()));
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

                                            ImageIO.write(outputImage4, "png", new File(linkSaveFile.getText() + listimage.get(i).getName()));
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
                for (List<image1> partition : Lists.partition(listimage, Integer.parseInt(soluongDS.getText()))) {
                    Workbook workbook = wirteExcel(partition);
                    try ( // Write the output to a file
                            FileOutputStream fileOut = new FileOutputStream(directory4.getParentFile().getPath() + "/contacts" + dem + ".xlsx")) {
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

                List<image1> listimage = new ArrayList<>();
                List<image1> listimagepost = new ArrayList<>();
                int j = 0;
                while ((line = reader.readLine()) != null) {
                    if (!(line.startsWith("*"))) {

                        try {

                            page = Jsoup.connect(line).userAgent(USER_AGENT).timeout(20 * 1000).get();

                            Elements links = page.select(".styles__link--3QJ5N");
                            if (!links.isEmpty()) {
                                links.remove(links.size() - 1);

                            }

                            for (Element link : links) {
                                try {

                                    System.out.println(link.attr("href"));
                                    page = Jsoup.connect(link.attr("href")).userAgent(USER_AGENT).timeout(20 * 1000).get();

                                    Element link2 = page.selectFirst(".PreviewGallery__rightColumn--2z6Zx .GalleryImage__img--12Vov");
                                    Elements listag = page.select("#work-tags a");
                                    // System.out.println("link2");

                                    String urlimage = link2.attr("src");

                                    //System.out.println(urlimage);
                                    String title = link2.attr("alt");

                                    String tag = "";
                                    for (Element element : listag) {
                                        tag = tag + element.attr("title") + ",";
                                    }
                                    tag = tag + ",gift,idea,design,quote,sayings,funny,present,humor,birthday,christmas,sarcasm";

                                    image1 a = new image1();

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

                        HttpPost post = new HttpPost("http://donthan.info/APIRED/get2.php");
                        ObjectMapper mapper = new ObjectMapper();
                        final ByteArrayOutputStream out = new ByteArrayOutputStream();

                        mapper.writeValue(out, listimagepost);

                        final byte[] data = out.toByteArray();
                        //System.out.println(new String(data));
                        String jsoninput = new String(data);
                        //System.out.println(jsoninput);
                        // add request parameter, form parameters
                        List<NameValuePair> urlParameters = new ArrayList<>();
                        urlParameters.add(new BasicNameValuePair("key", Key));
                        urlParameters.add(new BasicNameValuePair("urlimage", jsoninput));
                        urlParameters.add(new BasicNameValuePair("address", adip));

                        post.setEntity(new UrlEncodedFormEntity(urlParameters));
                        CloseableHttpClient httpClient = HttpClients.createDefault();
                        CloseableHttpResponse response = httpClient.execute(post);

                        //System.out.println(EntityUtils.toString(response.getEntity()));
                        List<image1> participantJsonList = mapper.readValue(EntityUtils.toString(response.getEntity()), new TypeReference<List<image1>>() {
                        });

                        if (!participantJsonList.isEmpty()) {
                            for (int i = 0; i < participantJsonList.size(); i++) {
                                try {
                                    URL url = new URL(participantJsonList.get(i).getUrlpng());
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

                                        try {

                                            int newHeight = Integer.parseInt(hight.getText());
                                            int newWidth = Integer.parseInt(width.getText());
                                            int newHeightresize = Integer.parseInt(hight.getText()) * Integer.parseInt(tileresize.getText()) / 100;
                                            int newWidthresize = Integer.parseInt(width.getText()) * Integer.parseInt(tileresize.getText()) / 100;
                                            // PNG supports transparency
                                            // int type = config.formatName.equals("png")?BufferedImage.TYPE_INT_ARGB:BufferedImage.TYPE_INT_RGB;
                                            ByteArrayInputStream bais = new ByteArrayInputStream(response2);

                                            BufferedImage outputImage = null;
                                            if (cantren.isSelected()) {

                                                outputImage = ImageIO.read(bais);
                                            } else {
                                                BufferedImage inputimage = ImageIO.read(bais);
                                                outputImage = trimImage(inputimage);
                                            }

                                            Scalr.Mode mode = Scalr.Mode.FIT_TO_HEIGHT;
                                            BufferedImage outputImage2 = Scalr.resize(outputImage, Scalr.Method.ULTRA_QUALITY, mode, newWidthresize - 10, newHeightresize - 10, Scalr.OP_ANTIALIAS);
                                            //System.out.println(outputImage2.getHeight());
                                            if (outputImage2.getWidth() > newWidth) {
                                                Scalr.Mode mode2 = Scalr.Mode.FIT_TO_WIDTH;
                                                outputImage2 = Scalr.resize(outputImage, Scalr.Method.ULTRA_QUALITY, mode2, newWidthresize - 10, newHeightresize - 10, Scalr.OP_ANTIALIAS);
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

                                                ImageIO.write(outputImage4, "png", new File(linkSaveFile.getText() + listimage.get(i).getName()));
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

                                                ImageIO.write(outputImage4, "png", new File(linkSaveFile.getText() + listimage.get(i).getName()));
                                            }

                                        } catch (Exception e) {
                                            continue;
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
                        abcxyz.setText("Reject IP hoặc có lỗi xảy ra xin thử lại");

                        return;
                    }

                }

                int dem = 0;
                for (List<image1> partition : Lists.partition(listimage, Integer.parseInt(soluongDS.getText()))) {
                    Workbook workbook = wirteExcel(partition);
                    try ( // Write the output to a file
                            FileOutputStream fileOut = new FileOutputStream(directory4.getParentFile().getPath() + "/contacts" + dem + ".xlsx")) {
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


    }//GEN-LAST:event_jButton1ActionPerformed

    public static Workbook wirteExcel(List<image1> listimage)
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

        for (image1 image : listimage) {
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
            ProtectionDomain pd = backup.class.getProtectionDomain();
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
            URL obj = new URL("http://donthan.info/APIRED/index.php?key=" + rand + "&adress=" + adip + "&method=create");
            HttpURLConnection con = (HttpURLConnection) obj.openConnection();
            con.setRequestMethod("GET");

            int responseCode = con.getResponseCode();
            //System.out.println("GET Response Code :: " + responseCode);
            if (responseCode == HttpURLConnection.HTTP_OK) { // success
                BufferedReader in = new BufferedReader(new InputStreamReader(
                        con.getInputStream()));
                String inputLine;
                StringBuffer response = new StringBuffer();

                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }
                in.close();

                // print result
                //System.out.println(response.toString());
                if (response.toString().contains("success")) {
                    makey.setText(String.valueOf(rand));
                    keyApi.setText(String.valueOf(rand));
                    Key = String.valueOf(rand);
                }
                String filename = PathLocal + "./key.txt";
                FileWriter fw = new FileWriter(filename); //the true will append the new data
                fw.write("");//appends the string to the file
                fw.close();
                FileWriter fw2 = new FileWriter(filename); //the true will append the new data
                fw2.write(String.valueOf(rand));//appends the string to the file
                fw2.close();

                //System.out.println(response.toString());
            } else {
                System.out.println("GET request not worked");
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

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {

                backup abc = new backup();
                abc.addWindowListener(new WindowAdapter() {
                    @Override
                    public void windowClosing(WindowEvent e) {
                        System.out.println("WindowClosingDemo.windowClosing");

                    }

                    @Override
                    public void windowOpened(WindowEvent e) {

                        try {
                            ProtectionDomain pd = backup.class.getProtectionDomain();
                            CodeSource cs = pd.getCodeSource();
                            URL location = cs.getLocation();
                            File directory4 = new File(location.getPath());
                            String PathLocal = directory4.getParentFile().getPath();
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
                        } catch (FileNotFoundException ex) {
                            Logger.getLogger(backup.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(backup.class.getName()).log(Level.SEVERE, null, ex);
        }
        return urlresturn;
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea abcxyz;
    private javax.swing.JButton buttonChosefoder;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JRadioButton cangiua;
    private javax.swing.JRadioButton cantren;
    private javax.swing.JCheckBox checkresize;
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
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
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
