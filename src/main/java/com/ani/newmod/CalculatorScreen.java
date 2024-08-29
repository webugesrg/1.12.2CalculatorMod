
package com.ani.newmod;import net.minecraft.client.gui.GuiButton;

import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.GuiTextField;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.client.Minecraft;
import scala.tools.nsc.doc.model.Public;

import java.util.logging.Level;
import java.util.logging.Logger;

import java.math.BigDecimal;
import java.util.Stack;
import java.util.StringTokenizer;

public class CalculatorScreen extends GuiScreen
{

    private final ITextComponent title;
    private GuiTextField textField;

    public CalculatorScreen()
    {
        this.title = new TextComponentString("");
    }

    private static final int BUTTON_ID_START = 100;


    public void sentenceAdd(String symbol)
    {
        textField.setText(textField.getText() + symbol);
    }

    public void sentenceUse(String symbol)
    {
        // Test the expression calculator with a sample expression
        String expression = textField.getText();
        try
        {
            BigDecimal result = calculateExpression(expression);
            textField.setText("" + result);
        } catch (RuntimeException e)
        {
            textField.setText("ERROR");
            e.printStackTrace(); // print the exception stack trace
            System.out.println("Error calculating expression: " + e.getMessage());
        }
    }

    public void setButton(int buttonId, int buttonX, int buttonY, String buttonText)
    {
        addButton(new GuiButton(buttonId, buttonX, buttonY, 20, 20, buttonText)
        {
            @Override
            public boolean mousePressed(Minecraft mc, int mouseX, int mouseY)
            {
                // Override the mousePressed method to handle button click
                if (super.mousePressed(mc, mouseX, mouseY))
                {
                    sentenceAdd(displayString); // Add the button text to the text field
                    return true;
                }
                return false;
            }
        });
    }

    @Override
    public void initGui()
    {
        super.initGui();

        // Set the text field width to 80% of the screen width
        int textFieldWidth = width * 8 / 10;
        int textFieldHeight = 20; // Set the text field height
        int textFieldX = (width - textFieldWidth) / 2; // Center the text field horizontally
        int textFieldY = 5; // Position the text field at the top of the screen

        textField = new GuiTextField(0, fontRenderer, textFieldX, textFieldY, textFieldWidth, textFieldHeight);
        textField.setMaxStringLength(64); // Set the maximum length of text allowed in the text field

        // Initialize buttons using a common method
        int buttonHeight = 20; // Set the button height
        int buttonWidth = 20;  // Set the button width
        int buttonY = 200; // Set the vertical position of the buttons
        int buttonSpacing = 2; // Set the spacing between buttons
        int buttonId = BUTTON_ID_START;

        // Create and add the 1st line of buttons
        int buttonX = 181; // Set the horizontal position of the button
        String[] btnText = {"1", "2", "3", "/"};

        for (int i = 0; i < 4; i++)
        {
            setButton(buttonId, buttonX, buttonY, btnText[i]);
            buttonX += buttonWidth + buttonSpacing; // Update the horizontal position for the next button
            buttonId++;
        }
        buttonX -= buttonWidth + buttonSpacing;

        //line 2
        buttonY -= buttonHeight + buttonSpacing;
        String[] btnText2 = {"*", "6", "5", "4"};
        for (int i = 0; i < 4; i++)
        {
            setButton(buttonId, buttonX, buttonY, btnText2[i]);
            buttonX -= buttonWidth + buttonSpacing;
            buttonId++;
        }
        buttonX += buttonWidth + buttonSpacing;

        //line 3
        buttonY -= buttonHeight + buttonSpacing;
        String[] btnText3 = {"7", "8", "9", "-"};
        for (int i = 0; i < 4; i++)
        {
            setButton(buttonId, buttonX, buttonY, btnText3[i]);
            buttonX += buttonWidth + buttonSpacing;
            buttonId++;
        }
        String[] btnText4 = {"+", ".", "0"};
        buttonX = 247;
        buttonY = 134;
        buttonX -= buttonWidth + buttonSpacing;
        for (int i = 0; i < 3; i++)
        {
            setButton(buttonId, buttonX, buttonY, btnText4[i]);
            buttonX -= buttonWidth + buttonSpacing;
            buttonId++;
        }

        //char equals

        addButton(new GuiButton(buttonId, 247, 134, buttonWidth, buttonHeight, "=")
        {
            @Override
            public boolean mousePressed(Minecraft mc, int mouseX, int mouseY)
            {
                // Override the mousePressed method to handle button click
                if (super.mousePressed(mc, mouseX, mouseY))
                {
                    sentenceUse(displayString);
                    return true;
                }
                return false;
            }
        });

//char c
        buttonId++;
        addButton(new GuiButton(buttonId, 247 + buttonWidth + buttonSpacing, 134, buttonWidth, buttonHeight, "c")
        {
            @Override
            public boolean mousePressed(Minecraft mc, int mouseX, int mouseY)
            {
                // Override the mousePressed method to handle button click
                if (super.mousePressed(mc, mouseX, mouseY))
                {
                    textField.setText("");
                    return true;
                }
                return false;
            }
        });

    }


    @Override
    public void drawScreen(int mouseX, int mouseY, float partialTicks)
    {
        drawDefaultBackground();
        super.drawScreen(mouseX, mouseY, partialTicks);

        Minecraft mc = Minecraft.getMinecraft();
        mc.fontRenderer.drawString(title.getFormattedText(), width / 2 - mc.fontRenderer.getStringWidth(title.getFormattedText()) / 2, 20, 0xffffffff);

        textField.drawTextBox();
    }
/*
The calculateExpression function is copied from kimi.moonshot.cn
 */
    public static BigDecimal calculateExpression(String expression) {
        BigDecimal result = BigDecimal.ZERO;
        BigDecimal num1 = BigDecimal.ZERO;
        BigDecimal num2 = BigDecimal.ZERO;
        String operator = "";

        StringTokenizer tokenizer = new StringTokenizer(expression, " +-/*()", true);
        while (tokenizer.hasMoreTokens()) {
            String token = tokenizer.nextToken();
            if (isNumeric(token)) {
                if (!operator.isEmpty()) {
                    num2 = new BigDecimal(token);
                    result = compute(num1, num2, operator);
                    num1 = result;
                } else {
                    num1 = new BigDecimal(token);
                }
                operator = "";
            } else if (token.equals("(")) {
                // Handle expressions within parentheses (simplified processing, full parentheses logic not implemented)
            } else if (token.equals(")")) {
                // Conclude the calculation of expressions within parentheses (simplified processing, full parentheses logic not implemented)
            } else {
                operator = token;
            }
        }

        return result;
    }

    private static boolean isNumeric(String token) {
        try {
            new BigDecimal(token);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private static BigDecimal compute(BigDecimal num1, BigDecimal num2, String operator) {
        switch (operator) {
            case "+":
                return num1.add(num2);
            case "-":
                return num1.subtract(num2);
            case "*":
                return num1.multiply(num2);
            case "/":
                return num1.divide(num2, 10, BigDecimal.ROUND_HALF_UP);
            default:
                throw new IllegalArgumentException("Unsupported operator: " + operator);
        }
    }
}

