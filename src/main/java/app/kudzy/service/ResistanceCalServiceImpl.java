package app.kudzy.service;

import app.kudzy.constants.CircuitType;
import app.kudzy.model.ResistanceCal;

import java.util.Scanner;

public class ResistanceCalServiceImpl implements ResistanceCalService {
  ResistanceCal resCal= new ResistanceCal();


    @Override
    public void message(String msg,String option) {
        String str="";
    switch (option){
        case "lowercase":
            str=msg.toLowerCase();
            break;
        case "uppercase":
            str=msg.toUpperCase();
            break;
    }
    System.out.println(str);
    }

    @Override
    public String readInput() {
        String inStr;
        Scanner sc =new Scanner(System.in);
        inStr=sc.next();
        return inStr;
    }


    @Override
    public void printLine() {
     System.out.println("=====================================================");
    }

    @Override
    public void printDottedLine() {
        System.out.println("---------------------------------------------------------");
    }

    @Override
    public Double performResistanceCal(String circuitType, String resVarStr) {
        Double resTotal=0.0;
        String [] str_split=resVarStr.trim().split(",");
        switch (circuitType.toUpperCase()) {
            case "SERIES":
                for(String str : str_split){
                  resTotal+=Double.parseDouble(str);
                }
                break;
            case "PARALLEL":
                  Double parTotal=0.0;
                for(String str : str_split){
                    parTotal+=(1/Double.parseDouble(str));
                }
                resTotal=(1/parTotal);
                break;

        }
        return resTotal;
    }

    @Override
    public Boolean checkValidity(String resValueStr) throws  NumberFormatException {
       String [] str_split=resValueStr.trim().split(",");
       Boolean isValid=false;
       for(String str : str_split){

           boolean isValidResValues = str.trim().matches("[^0-9,. ]");
         //&& isValidResValues
           if(Double.parseDouble(str.trim())>=0.0){
               isValid=true;
           }
       }
        return isValid;
    }

    @Override
    public String resValueStrListToReadable(String strIn) {
        String [] str_split=strIn.trim().split(",");
        String question="";

                for(String str : str_split){
                   question+=str+" omhs,";
                }


        return question;
    }

    @Override
    public int getResistorsNumber(String strIn) {
        return strIn.trim().split(",").length;
    }

    @Override
    public String resWorkings(String circuitType, String strIn) {
        String [] str_split=strIn.trim().split(",");
        String working="Total resistance = ";
        switch (circuitType.toUpperCase()) {
            case "SERIES":
                for(String str : str_split){
                    working+=str+" omhs + ";
                }
                break;
            case "PARALLEL":
                 String question="";
                for(String str : str_split){
                    question+="(1/"+str+")"+" omhs + ";
                }
              working+="(1/"+question+")";
                break;

        }
        return working;
    }

    @Override
    public void setCiruitType(String strIn) {
        int inInt=Integer.parseInt(strIn);
        if(inInt>0&& inInt<3){
            switch (inInt){
                case 1:
                    resCal.setCircuitType(CircuitType.SERIES);
                    break;
                case 2:
                    resCal.setCircuitType(CircuitType.PARALLEL);
                    break;
            }
        }
    }

    @Override
    public void mainServiceRunner() {
     printLine();
     message("Select the circuit type.\r\n Press digit a to select the circuit type. \r\n 1. Series \n 2. Parallel","uppercase");
     setCiruitType(readInput());
     message("Enter the resistor circuit values.Note that only numbers separated by comma are accepted.\r\n e.g 2.3, 6, 21.05 ","lowercase");
     String enteredStr=readInput();
     if(checkValidity(enteredStr)) {
            resCal.setResValueStr(enteredStr);
            resCal.setResNo(getResistorsNumber(enteredStr));
         printDottedLine();
            message("Your question.\r\n","uppercase");
            message("Calculate the total resistance of "+resCal.getResNo()+" resistor(s) in a "+resCal.getCircuitType()+" circuit with the following values "+resValueStrListToReadable(enteredStr)+".\r\n Press enter to calculate.","lowercase");
            printDottedLine();
         message("Our workings.\r\n","uppercase");
         message(resWorkings(resCal.getCircuitType().toString(), resCal.getResValueStr()),"lowercase");

         message("                  =  "+performResistanceCal(resCal.getCircuitType().toString(),enteredStr)+" omhs","uppercase");
         printDottedLine();
         message("\r\n","uppercase");
         printLine();
     }else{
            message("Invalid resistor values entered. try again with diffrent values.","lowercase");
        }

    }
}
