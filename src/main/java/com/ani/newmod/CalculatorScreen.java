package com.ani.newmod;import net.minecraft.client.gui.GuiButton;

import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.GuiTextField;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.client.Minecraft;


public class CalculatorScreen extends GuiScreen {

    private final ITextComponent title;
    private GuiTextField textField;

    public CalculatorScreen() {
        this.title = new TextComponentString("Calculator");
    }

    private static final int BUTTON_ID_START = 100;

    int a;

    @Override
    public void initGui() {
        super.initGui();

        int buttonWidth = width / 4;
        int buttonHeight = 20;
        int padding = 5;

        int textFieldWidth = width * 8 / 10;
        int textFieldHeight = 20;
        int textFieldX = (width - textFieldWidth) / 2;
        int textFieldY = 5;

        textField = new GuiTextField(0, fontRenderer, textFieldX, textFieldY, textFieldWidth, textFieldHeight);
        textField.setMaxStringLength(64);

        int buttonId = BUTTON_ID_START;

        //1-3 /
        for (int i = 0; i < 4; i++) {
            if (i < 3) {
                addButton(new GuiButton(buttonId++, (width - buttonWidth * 4) / 2 + i * (buttonWidth + padding), height - 90, buttonWidth, buttonHeight, String.valueOf(i + 1)));
            } else {
                addButton(new GuiButton(buttonId++, (width - buttonWidth * 4) / 2 + i * (buttonWidth + padding), height - 90, buttonWidth, buttonHeight, "/"));
            }
        }

        //4-6 *
        for (int i = 0; i < 4; i++) {
            if (i < 3) {
                addButton(new GuiButton(buttonId++, (width - buttonWidth * 4) / 2 + i * (buttonWidth + padding), height - 115, buttonWidth, buttonHeight, String.valueOf(i + 4)));
            } else {
                addButton(new GuiButton(buttonId++, (width - buttonWidth * 4) / 2 + i * (buttonWidth + padding), height - 115, buttonWidth, buttonHeight, "*"));
            }
        }

        //7-9 -
        for (int i = 0; i < 4; i++) {
            if (i < 3) {
                addButton(new GuiButton(buttonId++, (width - buttonWidth * 4) / 2 + i * (buttonWidth + padding), height - 140, buttonWidth, buttonHeight, String.valueOf(i + 7)));
            } else {
                addButton(new GuiButton(buttonId++, (width - buttonWidth * 4) / 2 + i * (buttonWidth + padding), height - 140, buttonWidth, buttonHeight, "-"));
            }
        }
        //0, ., +, =
        for (int i = 0;i < 4 ; i++){
            switch (i){
                case 0 :
                    addButton(new GuiButton(buttonId++, (width - buttonWidth * 4) / 2, height - 165, buttonWidth, buttonHeight, "0"));
                    break;
                case 1 :
                    addButton(new GuiButton(buttonId++, (width - buttonWidth * 4) / 2 + i * (buttonWidth + padding), height - 165, buttonWidth, buttonHeight, "."));
                    break;
                case 2 :
                    addButton(new GuiButton(buttonId++, (width - buttonWidth * 4) / 2 + i * (buttonWidth + padding), height - 165, buttonWidth, buttonHeight, "+"));
                    break;
                case 3 :
                    addButton(new GuiButton(buttonId++, (width - buttonWidth * 4) / 2 + 3 * (buttonWidth + padding), height - 165, buttonWidth, buttonHeight, "=") {
                        @Override
                        public boolean mousePressed(Minecraft mc, int mouseX, int mouseY) {
                            // 当按钮被点击时，执行这里的代码
                            textField.setText("Result goes here");
                            return super.mousePressed(mc, mouseX, mouseY);
                        }
                });
                    break;

            }
        }
    }

    @Override
    public void drawScreen(int mouseX, int mouseY, float partialTicks) {
        drawDefaultBackground();
        super.drawScreen(mouseX, mouseY, partialTicks);

        Minecraft mc = Minecraft.getMinecraft();
        mc.fontRenderer.drawString(title.getFormattedText(), width / 2 - mc.fontRenderer.getStringWidth(title.getFormattedText()) / 2, 20, 0xffffffff);

        textField.drawTextBox();
    }



}