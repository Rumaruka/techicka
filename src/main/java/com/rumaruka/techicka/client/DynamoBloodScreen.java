package com.rumaruka.techicka.client;

import cofh.core.util.helpers.GuiHelper;
import cofh.lib.util.helpers.StringHelper;
import cofh.thermal.core.client.gui.ThermalGuiHelper;
import cofh.thermal.lib.client.gui.DynamoScreenBase;
import com.rumaruka.techicka.common.modules.thermal.bloodmagic.inventory.BloodDynamoContainer;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.ITextComponent;

public class DynamoBloodScreen extends DynamoScreenBase<BloodDynamoContainer> {
    public static final String TEX_PATH = "thermal:textures/gui/container/fluid_dynamo.png";
    public static final ResourceLocation TEXTURE = new ResourceLocation("thermal:textures/gui/container/fluid_dynamo.png");

    public DynamoBloodScreen(BloodDynamoContainer container, PlayerInventory inv, ITextComponent titleIn) {
        super(container, inv, container.tile, StringHelper.getTextComponent("block.techicka.dynamo_blood"));
        this.texture = TEXTURE;
        this.info = GuiHelper.appendLine(GuiHelper.generatePanelInfo("info.techicka.dynamo_blood"), "info.techicka.blood.throttle");
    }

    public void init() {
        super.init();
        this.addElement(GuiHelper.setClearable(GuiHelper.createMediumFluidStorage(this, 34, 22, this.tile.getTank(0)), this.tile, 0));
        this.addElement(ThermalGuiHelper.createDefaultDuration(this, 80, 35, "cofh_core:textures/gui/elements/scale_flame.png", this.tile));
    }
}
