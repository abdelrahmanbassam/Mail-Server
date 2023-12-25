<template>
    <div>

        <h1 class="greeting">Welcome to Mail Server</h1>
        <v-sheet width="300" class="mx-auto">
      <v-form fast-fail @submit.prevent>
          <v-text-field
          v-model="email"
          label="email"
          :rules="emailRules"
        ></v-text-field>
  
        <v-text-field
          v-model="password"
          label="password"
          :rules="passwordRules"
        ></v-text-field>
        <v-btn @click="signIn" type="submit" block class="mt-2" color="blue">Sign In</v-btn>
        <h3 class="sentence">If you do not have account</h3>
            <v-btn @click="signUp" type="submit" block class="mt-2" color="red">Sign Up</v-btn> 
      </v-form>
    </v-sheet>
    </div>
  </template>
 <script>
 export default {
     data: () => ({
         email: '',
         emailRules: [
       value => {
         if (value?.length > 3) return true
         return 'Incorrect email'
       },
     ],
     password: '',
     passwordRules: [
       value => {
         if (/[^0-9]/.test(value)) return true
         return 'Incorrect password'
       },
     ],
   }),
   methods: {
     signIn() {
       const isEmailValid = this.emailRules[0](this.email) === true;
       const isPasswordValid = this.passwordRules[0](this.password) === true;
       if (isEmailValid && isPasswordValid) {
         this.$router.push('/list');
       } else {
         console.log('Incorrect email or password');
       }
     },
     signUp() {
        this.$router.push('/signup');
     },
   },
 };
 </script>
  <style>
   .greeting{
    color: rgb(175, 74, 43);
    margin-left: 36%;
   }
   .sentence{
    color: gray;
    margin-left: 10%;
    margin-top: 10%;
   }
    </style>
      