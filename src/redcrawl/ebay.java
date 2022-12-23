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
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;

import java.net.NetworkInterface;

import java.net.URL;
import java.net.URLConnection;
import java.security.CodeSource;
import java.security.ProtectionDomain;
import java.util.ArrayList;
import java.util.Arrays;

import java.util.Enumeration;

import java.util.List;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JFileChooser;

import javax.swing.JOptionPane;
import javax.swing.SwingWorker;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
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
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import static redcrawl.c.Key;

/**
 *
 * @author me
 */
public class ebay extends javax.swing.JFrame {

    public static String status = "";
    private final String USER_AGENT = "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/106.0.0.0 Safari/537.36";
    /**
     *
     * Creates new form downloadanh
     */
    JFileChooser chooser;
    String choosertitle;
    String stringUrlSave;
    static String Key;
    private Document page;

    public ebay() {

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
        jLabel2 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();

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

            jTextArea1.setColumns(20);
            jTextArea1.setRows(5);
            jScrollPane2.setViewportView(jTextArea1);

            javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
            getContentPane().setLayout(layout);
            layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addGap(199, 199, 199)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGap(179, 179, 179))
                        .addGroup(layout.createSequentialGroup()
                            .addContainerGap()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(167, 167, 167)
                                    .addComponent(jScrollPane2)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(result))
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(buttonChosefoder, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jScrollPane1)
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(linkSaveFile)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 8, javax.swing.GroupLayout.PREFERRED_SIZE)))))))
                    .addContainerGap())
            );
            layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap(44, Short.MAX_VALUE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addComponent(result)
                            .addGap(119, 119, 119))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(linkSaveFile, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(buttonChosefoder, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(13, 13, 13))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel4))
                    .addGap(98, 98, 98))
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

            ProtectionDomain pd = c.class.getProtectionDomain();
            CodeSource cs = pd.getCodeSource();
            URL location = cs.getLocation();

            File directory4 = new File(location.getPath());
            String PathLocal = directory4.getParentFile().getPath().replace("%20", " ");
            System.out.println(PathLocal);

            String s[] = jTextArea1.getText().split("\\r?\\n");
            ArrayList<String> arrList = new ArrayList<>(Arrays.asList(s));
            Config conf = new Config();
            conf.setUrlSave(this.linkSaveFile.getText());
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            String configInfo = gson.toJson(conf);
            String fileconfig = PathLocal + "./config.txt";
            FileWriter fw = new FileWriter(fileconfig); //the true will append the new data
            fw.write("");//appends the string to the file
            fw.close();
            fw = new FileWriter(fileconfig); //the true will append the new data
            fw.write(configInfo);//appends the string to the file
            fw.close();

            // abcxyz.read(reader, null);
            List<Image> listimage = new ArrayList<>();
            List<Image> listimage123 = new ArrayList<>();
            int j = 0;
            for (String line : arrList) {

                if (!line.isEmpty()) {

                    try {
                        status = "Lấy thông tin \n" + line + "\n" + "link số: " + (j + 1);
                        setStatus();
                        page = Jsoup.connect(line).userAgent(USER_AGENT).timeout(20 * 1000).get();

                        Elements links = page.select(".sresult");
//                            if (!links.isEmpty()) {
//                                links.remove(links.size() - 1);
//
//                            }

                        for (Element link : links) {
                            try {

                                Element elmIma = link.getElementsByTag("img").first();
                                String src = elmIma.attr("src");

                                String urlimage = src.replace("225", "1600");

                                //System.out.println(urlimage);
                                Element elmTtitle = link.getElementsByTag("h3").first();
                                Element elmTtitleA = elmTtitle.getElementsByTag("a").first();
                                String title = elmTtitleA.attr("title");

                                Image a = new Image();

                                a.url = urlimage;

                                a.alt = title.replaceAll("[^a-zA-Z0-9-,\\s+]", "");
                                a.name = title.replaceAll("[^a-zA-Z0-9\\s+]", "") + j + ".png";
                                listimage123.add(a);
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
            
            
            if (!listimage123.isEmpty()) {
                                    for (int i = 0; i < listimage123.size(); i++) {
                                        try {
                                            status = "Lấy file \n" + listimage123.get(i).getUrl() + "\n" + "link số: " + (i + 1);
                                            setStatus();
                                            URL url = new URL(listimage123.get(i).getUrl());
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
                                            FileOutputStream fos = new FileOutputStream(linkSaveFile.getText() + listimage123.get(i).getAlt().replace("Click this link to access ", "") + ".jpg");
                                            fos.write(response2);
                                            fos.close();

                                        } catch (Exception e) {
                                            e.printStackTrace();
                                            continue;
                                        }
                                    }
                                }

//            if (!listimage.isEmpty()) {
//
//                try {
//
////                     
//                    if (!listimage.isEmpty()) {
//                        for (int i = 0; i < listimage.size(); i++) {
//                            try {
//                                status = "Lấy file \n" + listimage.get(i).getUrl() + "\n" + "link số: " + (i + 1);
//                                setStatus();
//                                URL url = new URL(listimage.get(i).getUrl());
//                                //System.out.println(FilenameUtils.getBaseName(url.getPath())); // -> file
//                                InputStream in = new BufferedInputStream(url.openStream());
//                                ByteArrayOutputStream out2 = new ByteArrayOutputStream();
//                                byte[] buf = new byte[2048];
//                                int n = 0;
//                                while (-1 != (n = in.read(buf))) {
//                                    out2.write(buf, 0, n);
//                                }
//                                out2.close();
//                                in.close();
//                                byte[] response2 = out2.toByteArray();
//                                FileOutputStream fos = new FileOutputStream(linkSaveFile.getText() + listimage.get(i).getAlt().replace("Click this link to access ", "") + ".jpg");
//                                fos.write(response2);
//                                fos.close();
//
//                            } catch (Exception e) {
//                                e.printStackTrace();
//                                continue;
//                            }
//                        }
//                    }
//
//                } catch (Exception e) {
//                    abcxyz.setText("Reject IP hoặc có lỗi xảy ra xin thử lại");
//
//                    return;
//                }
//
//            }

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

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField2ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {

                ebay abc = new ebay();
                abc.addWindowListener(new WindowAdapter() {
                    @Override
                    public void windowClosing(WindowEvent e) {
                        System.out.println("WindowClosingDemo.windowClosing");

                    }

                    @Override
                    public void windowOpened(WindowEvent e) {

                        try {
                            ProtectionDomain pd = ebay.class.getProtectionDomain();
                            CodeSource cs = pd.getCodeSource();
                            URL location = cs.getLocation();
                            File directory4 = new File(location.getPath());
                            String PathLocal = directory4.getParentFile().getPath().replace("%20", " ");
                            String Fileconfig = PathLocal + "./config.txt";
                            File fileconfig = new File(Fileconfig);
                            Scanner myReader = new Scanner(fileconfig);
                            String configSTR = "";
                            while (myReader.hasNextLine()) {
                                configSTR = configSTR + myReader.nextLine();

                            }
                            myReader.close();

                            Gson gson = new GsonBuilder().setPrettyPrinting().create();
                            Config conf = gson.fromJson(configSTR, Config.class);
                            abc.linkSaveFile.setText(conf.getUrlSave());

                        } catch (FileNotFoundException ex) {
                            Logger.getLogger(ebay.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(ebay.class.getName()).log(Level.SEVERE, null, ex);
        }
        return urlresturn;
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private static javax.swing.JTextArea abcxyz;
    private javax.swing.JButton buttonChosefoder;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField linkSaveFile;
    private javax.swing.JLabel result;
    // End of variables declaration//GEN-END:variables
}
