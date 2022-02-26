package com.general_hello.commands.commands;

import com.jagrosh.jdautilities.command.SlashCommand;
import net.dv8tion.jda.api.events.interaction.SlashCommandEvent;

public class CreateCodeCommand extends SlashCommand {
    public CreateCodeCommand() {
        this.name = "create";
        this.help = "Creates your unique code.";
    }

    @Override
    protected void execute(SlashCommandEvent event) {
        if (InviteUser.isCodeCreated(event.getUser())) {
            event.reply("The code is already created! Type /view_code to see it!").queue();
            return;
        }

        InviteUser.setCodeCreated(event.getUser());
        event.reply("Successfully created the code! Kindly use /view_code to view it.").queue();
    }
}
