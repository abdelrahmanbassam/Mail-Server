<template>

        <v-dialog v-model="dialog" persistent width="500">
    <template v-slot:activator="{ props }">
        <v-btn
        color="primary"
        v-bind="props"
        prepend-icon="mdi-pen"
        >
        Compose
    </v-btn>
</template>

<v-card class="mx-auto" width="600">
    <!-- make a compose card that take to, subject, body, and a proiorety as input .. put in the top icon to cancel, and in the bottom two options (send, drat)-->
    <v-card-title>
        <v-row>
            <v-spacer></v-spacer>
            <v-icon right @click="close">mdi-close</v-icon>
        </v-row>
        <v-col>
            <v-text-field
            v-model="to"
            label="To"
            :rules="toRules"
            required
            ></v-text-field>
            <v-select
            v-model="priorety"
            :items="prioretyList"
            label="Priorety"
            ></v-select>
        </v-col>
        </v-card-title>
        <v-card-text>
            <v-text-field
            v-model="subject"
            label="Subject"
            ></v-text-field>
            <v-textarea
            v-model="body"
            label="Body"
            ></v-textarea>
        </v-card-text>
        <v-card-actions>
            <v-btn
            color="primary"
            text
            @click="close"
            >
            Save as Draft
        </v-btn>
        <v-spacer></v-spacer>
        <v-btn
        color="primary"
        outlined
        @click="valid"
        >
        Send
    </v-btn>
</v-card-actions>

</v-card>

</v-dialog>

</template>

<script>
export default {
    
    data() {
        return {
            toRules: [
                value => {
                if (value?.length >= 3) return true
                return 'Please specify at least one recipient'
                }
            ],

            contacts:['djd', 'cnmcn', 'djhjd'],
            prioretyList:['very high', 'high',  'medium', 'low','very low'],
            dialog: false,
            priorety: 'low',
            to:'',
            subject:'',
            body:'',
            attachments:[],
        }
    },
    methods:{
        clear(){
            this.dialog = false;
            this.priorety= 'low';
            this.to='';
            this.subject='';
            this.body='';
            this.attachments=[];
            
        },
        close(){
            this.dialog = false;
            // if (this.$refs.form.validate()) this.clear();

            this.clear();
        },
        // validate the input of the compose form to send the email
        valid(){
            if (this.$refs.form.validate()) this.send();
        },
        
        send(){this.clear();
        this.dialog = false;}
        //send a post request the data email to the server
        // async send(){},
        
        
        
        
    },
    updated(){
    }

}
</script>

<style>

</style>