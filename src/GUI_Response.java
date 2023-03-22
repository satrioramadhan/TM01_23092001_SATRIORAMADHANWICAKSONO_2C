import Model.ResponseModel;
import Network.ConnectURI;
import org.json.JSONArray;
import org.json.JSONObject;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import java.util.ArrayList;

public class GUI_Response {
    private JPanel myPannel;
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JButton exitButton;
    private JButton submitButton;
    private JButton _mn;


    public JPanel getmyPanel(){
        return myPannel;
    }
    public JButton get_mn() {
        return _mn;
    }
    public static void main(String[] args) {
        JFrame frame = new JFrame("GUI_Response");
        frame.setContentPane(new GUI_Response().myPannel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        frame.setUndecorated(true);
    }

    public GUI_Response() {
    submitButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            ConnectURI koneksisaya = new ConnectURI();
            URL myAddress = koneksisaya.buildURL
                    ("https://harber.mimoapps.xyz/api/getaccess.php");
            String response = null;
            try {
                response = koneksisaya.getResponseFromHTTpUrl(myAddress);
            } catch (Exception ex) {
                System.out.println(ex);
            }
            System.out.println("respon anda" + response);

            JSONArray responseJSON = new JSONArray(response);
            ArrayList<ResponseModel> responseModel = new ArrayList<>();
            for (int i = 0; i < responseJSON.length(); i++) {
                ResponseModel resModel = new ResponseModel();
                JSONObject myJSONObject = responseJSON.getJSONObject(i);
                resModel.setMsg(myJSONObject.getString("message"));
                resModel.setStatus(myJSONObject.getString("status"));
                resModel.setComment(myJSONObject.getString("comment"));
                responseModel.add(resModel);

            }
            System.out.println("Response are: ");
            for (int index = 0; index < responseModel.size(); index++) {
               textField1.setText(responseModel.get(index).getMsg());
               textField2.setText(responseModel.get(index).getStatus());
               textField3.setText(responseModel.get(index).getComment());
            }
        }
    });
        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               System.exit(0);
            }
        });
    }}
