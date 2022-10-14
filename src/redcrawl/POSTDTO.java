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
public class POSTDTO {

    private param input;

    public param getInput() {
        return input;
    }

    public void setInput(param input) {
        this.input = input;
    }
    public class param {

        private String messageRequest;
        private String type;
        private String documentName;
        private String clientID;
        private String customerId;
        private String customerName;
        private String bussiness;
        private String folderBy;
        private String folderAt;
        private String folderId;
        private String folderClass;
        private String batchStore;
        private String username;

        public String getMessageRequest() {
            return messageRequest;
        }

        public void setMessageRequest(String messageRequest) {
            this.messageRequest = messageRequest;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getDocumentName() {
            return documentName;
        }

        public void setDocumentName(String documentName) {
            this.documentName = documentName;
        }

        public String getClientID() {
            return clientID;
        }

        public void setClientID(String clientID) {
            this.clientID = clientID;
        }

        public String getCustomerId() {
            return customerId;
        }

        public void setCustomerId(String customerId) {
            this.customerId = customerId;
        }

        public String getCustomerName() {
            return customerName;
        }

        public void setCustomerName(String customerName) {
            this.customerName = customerName;
        }

        public String getBussiness() {
            return bussiness;
        }

        public void setBussiness(String bussiness) {
            this.bussiness = bussiness;
        }

        public String getFolderBy() {
            return folderBy;
        }

        public void setFolderBy(String folderBy) {
            this.folderBy = folderBy;
        }

        public String getFolderAt() {
            return folderAt;
        }

        public void setFolderAt(String folderAt) {
            this.folderAt = folderAt;
        }

        public String getFolderId() {
            return folderId;
        }

        public void setFolderId(String folderId) {
            this.folderId = folderId;
        }

        public String getFolderClass() {
            return folderClass;
        }

        public void setFolderClass(String folderClass) {
            this.folderClass = folderClass;
        }

        public String getBatchStore() {
            return batchStore;
        }

        public void setBatchStore(String batchStore) {
            this.batchStore = batchStore;
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

    }
    

}
