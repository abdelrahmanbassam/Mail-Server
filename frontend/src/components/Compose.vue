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
    <v-form class="pa-3">
      <v-text-field
        label="To"
        single-line
        variant="underlined"
        v-model="to"
      ></v-text-field>
      <v-text-field
        label="Subject"
        single-line
        variant="underlined"
        v-model="subject"
      ></v-text-field>
      <v-textarea 
      label="Body" 
      single-line variant="underlined"
      v-model="body"
      ></v-textarea>
    

          
    <v-row>
        <v-col>

            <v-menu flat>
                <template v-slot:activator="{ props }">
                    <v-btn
                    color="grey"
                v-bind="props"
                >
                set priorety
            </v-btn>
        </template>
        <v-list>
            <v-list-item
            v-for="priorety in prioretyList"
            :key="priorety"
                :value="priorety"
                >
                <v-list-item-title>{{ priorety }}</v-list-item-title>
            </v-list-item>
        </v-list>
    </v-menu>
</v-col>

    <v-col>
        <h3 class="pa-3">{{ this.priorety }}</h3>
    </v-col>
    </v-row>

    
    <v-card-actions>
        <v-file-input
        label="Attachment"
        v-model="attachments"
        multiple
        show-size
        @click.prevent
        >
    </v-file-input>
    <v-spacer></v-spacer>        
    
    <v-btn
    color="blue-darken-2"
    variant="text"
    @click="close"
    >
    close
          </v-btn>
          <v-btn
          class="text-none ms-4 text-white"
            color="blue-darken-2"
            rounded="3"
            variant="flat"
            @click="send"
            >
            Send
        </v-btn>
        
    </v-card-actions>
</v-form>
</v-card>

    </v-dialog>

</template>

<script>
export default {

    data() {
        return {
            prioretyList:['very high', 'high',  'medium', 'low','very low'],
            dialog: false,
            mailData: {
                priorety: 'low',
                to:'',
                subject:'',
                body:'',
                attachments:[],
            }
        }
    },
    methods:{
        clear(){
            this.dialog = false;
            this.mailData.priorety= 'low';
            this.mailData.to='';
            this.mailData.subject='';
            this.mailData.body='';
            this.mailData.attachments=[];
            
        },
        close(){
            this.dialog = false;
            // if (this.$refs.form.validate()) this.clear();

            this.clear();
        },
        send(){
            // let formData = new FormData();
            // for(let i=0;i<this.attachments.length;i++){
            //     formData.append('file[]', this.attachments[i]);
            //     };
            // console.log(formData);
        }
    },
    updated(){
    }

}
</script>

<style>

</style>