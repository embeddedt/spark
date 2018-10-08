/*
 * This file is part of spark.
 *
 *  Copyright (c) lucko (Luck) <luck@lucko.me>
 *  Copyright (c) contributors
 *
 *  This program is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 *
 *  This program is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *
 *  You should have received a copy of the GNU General Public License
 *  along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package me.lucko.spark.forge;

import me.lucko.spark.profiler.TickCounter;

import net.minecraft.client.Minecraft;
import net.minecraft.command.ICommandSender;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.text.ITextComponent;
import net.minecraftforge.client.ClientCommandHandler;
import net.minecraftforge.fml.common.gameevent.TickEvent;

import java.util.Collections;
import java.util.List;

public class ForgeClientCommandHandler extends ForgeCommandHandler {

    public static void register() {
        ClientCommandHandler.instance.registerCommand(new ForgeClientCommandHandler());
    }

    @Override
    protected void broadcast(ITextComponent msg) {
        Minecraft.getMinecraft().player.sendMessage(msg);
    }

    @Override
    protected TickCounter newTickCounter() {
        return new ForgeTickCounter(TickEvent.Type.CLIENT);
    }

    @Override
    public String getLabel() {
        return "sparkclient";
    }

    @Override
    public String getName() {
        return "sparkclient";
    }

    @Override
    public List<String> getAliases() {
        return Collections.singletonList("cprofiler");
    }

    @Override
    public boolean checkPermission(MinecraftServer server, ICommandSender sender) {
        return true;
    }
}