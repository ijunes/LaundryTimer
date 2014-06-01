package com.ijunes.timer.views;


import com.ijunes.timer.core.Machine;

/**
 * Created by kang on 6/1/2014.
 */
public class MachineView {
    private final Machine machine;
    public enum Template{
        FREEMARKER("freemarker/machine.ftl"),
        MUSTACHE("mustache/person.mustache");

        private String templateName;
        private Template(String templateName){
            this.templateName = templateName;
        }

        public String getTemplateName(){
            return templateName;
        }
    }

    public PersonView(PersonView.Template template, Person person) {
        super(template.getTemplateName());
        this.person = person;
    }

    public Person getPerson() {
        return person;
    }
}
