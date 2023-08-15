/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sparktestbook;

/**
 *
 * @author AVShrez
 */
public enum StatusResponse {
    SUCCESS("Success"),
    ERROR("Error");

    private String status;

    // constructors, getters
    StatusResponse(String status) {
        this.status = status;
    }

    public String getStatus() {
        return this.status;
    }

}
