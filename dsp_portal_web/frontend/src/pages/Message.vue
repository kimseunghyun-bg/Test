<template>
    <div class="content">
        <div class="container-fluid">
            <card>
                <div class="row">
                    <div class="col-md-12">
                        <h5>Alert Style</h5>
                    </div>
                </div>
                <div class="row">
                        
                    <div class="col-md-4">
                        <button class="btn btn-default btn-block" @click="alertExample1"> default </button>
                    </div>                        
                    <div class="col-md-4">
                        <button class="btn btn-default btn-block" @click="alertExample2"> Title Change </button>
                    </div>
                    <div class="col-md-4">
                        <button class="btn btn-default btn-block" @click="alertExample3"> Success </button>
                    </div>
                </div>
                <br>
                <div class="row">
                    <div class="col-md-4">
                        <button class="btn btn-default btn-block" @click="alertExample4"> Warning </button>
                    </div>
                    
                    <div class="col-md-4">
                        <button class="btn btn-default btn-block" @click="alertExample5"> Error </button>
                    </div>
                    
                </div>
                <div class="row">
                    <div class="col-md-12">
                        <h5>Confirm Style</h5>
                    </div>
                </div>
                <div class="row">
                    <div class="col-md-6">
                        <button class="btn btn-default btn-block" @click="confirmExample0"> default </button>
                    </div>
                    <div class="col-md-6">
                        <button class="btn btn-default btn-block" @click="confirmExample1"> Title Change </button>
                    </div>
                </div>
                <br>
                <div class="row">                    
                    <div class="col-md-6">
                        <button class="btn btn-default btn-block" @click="confirmExample2"> Success </button>
                    </div>
                    <div class="col-md-6">
                        <button class="btn btn-default btn-block" @click="confirmExample3"> Warning </button>
                    </div>   
                </div>
                <div class="row">
                    <div class="col-md-12">
                        <h5>Prompt Style</h5>
                    </div>
                </div>
                <div class="row">                    
                    <div class="col-md-6">
                        <button class="btn btn-default btn-block" @click="promptExample0"> Prompt1 </button>
                    </div>
                    <div class="col-md-6">
                        <button class="btn btn-default btn-block" @click="promptExample1"> Prompt2 </button>
                    </div>   
                </div>
                <br>
                <div class="row">                    
                    <div class="col-md-6">
                        <button class="btn btn-default btn-block" @click="promptExample3"> Prompt3 </button>
                    </div>
                    <div class="col-md-6">
                        <button class="btn btn-default btn-block" @click="promptExample4"> Prompt4 </button>
                    </div>   
                </div>
                <div class="row">
                    <div class="col-md-12">
                        <h5>Advanced Style</h5>
                    </div>
                </div>
                <div class="row">                    
                    <div class="col-md-6">
                        <button class="btn btn-default btn-block" @click="advancedExample2"> advanced1 </button>
                    </div>
                    <div class="col-md-6">
                        <button class="btn btn-default btn-block" @click="advancedExample3"> advanced2 </button>
                    </div>   
                </div>
                
            </card>
        </div>
    </div>
</template>
<script>
export default{
    
    methods:
    {
        alertExample1(){
            this.$alert("기본 메세지").then(() =>
             console.log("Closed")
            );
        },
        alertExample2() {
            this.$alert("타이틀 명 변경 가능", "타이틀!!!").then(
            () => console.log("Closed")
            );
        },
        alertExample3() {
            this.$alert(
            "내용",
            "Success",
            "success"
            ).then(() => console.log("Closed"));
        },
        alertExample4() {
            this.$alert(
            "내용",
            "Warning",
            "warning"
            ).then(() => console.log("Closed"));
        },
        alertExample5() {
            this.$alert(
            "내용",
            "Error",
            "error"
            ).then(() => console.log("Closed"));
        },
        confirmExample0() {
            window.confirm("This is normal confirm.");
        },
        confirmExample1() {
            this.$confirm("This is cool confirm.", "Confirm");
        },
        confirmExample2() {
            this.$confirm(
            "This is cool confirm with question icon.",
            "Question",
            "question"
            )
            .then((r) => {
                console.log(r);
            })
            .catch(() => {
                console.log("OK not selected.");
            });
        },
        confirmExample3() {
            this.$confirm("This is cool confirm with error icon.", "Error", "error")
            .then((r) => {
                console.log(r);
                this.$alert("OK selected.");
            })
            .catch(() => {
                console.log("OK not selected.");
            });
        },
        promptExample0() {
            window.alert(window.prompt("Input your name", "John Doe"));
        },
        promptExample1() {
            this.$prompt("Input your name", "John Doe").then((r) => {
            if (r) this.$alert(r, "Your name is:", "success");
            });
        },
        promptExample2() {
            this.$prompt("Input your name", "John Doe", "Example", "question")
            .then((r) => {
                this.$alert(r, "Your name is:", "success");
            })
            .catch(() => console.log("canceled"));
        },
        promptExample3() {
            this.$prompt(
            "Input your email",
            "someone@example.com",
            "Example",
            "question",
            { input: "email" }
            )
            .then((r) => {
                this.$alert(r, "Your email is:", "success");
            })
            .catch(() => console.log("canceled"));
        },        
        advancedExample2() {
            this.$alert(
            "This is advanced alert with custom button text",
            "Example",
            "success",
            {
                confirmButtonText: "Got it!"
            }
            );
        },
        advancedExample3() {
            this.$confirm("This is dialog has reversed buttons.", "Error", "error", {
            reverseButtons: true
            })
            .then((r) => {
                console.log(r);
            })
            .catch(() => {
                console.log("OK not selected.");
            });
        }
    }
};
</script>
