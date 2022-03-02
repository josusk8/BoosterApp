package com.example.boosterweigthlifting.ui.popup;

public class VideoHtmlString {

    private String html;
    private String example = "https://www.youtube.com/embed/9xQp2sldyts";

    public VideoHtmlString() {

        this.html =
                "<html style=\"background:black\"> " +
                        "<iframe  style=\"display:block; width:100%; heigth:100%\" " +
                        "src=\"" +
                        example +
                        "\" frameborder=\"0\" " +
                        "allow=\"accelerometer; autoplay; clipboard-white; encrypted-media; gyroscope; picture-in-picture\" " +
                        "allowfullscreen></iframe>"
        ;

    }

    public String getHtmlString(String UrlVideo) {
        this.html =
                "<html style=\"background:black\"> " +
                        "<iframe  style=\"display:block; width:100%; heigth:100%\" " +
                        "src=\"" +
                        UrlVideo +
                        "\" frameborder=\"0\" " +
                        "allow=\"accelerometer; autoplay; clipboard-white; encrypted-media; gyroscope; picture-in-picture\" " +
                        "allowfullscreen></iframe>"
        ;




        return html;
    }
}
