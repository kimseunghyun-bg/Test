<template>
    <div>
        <h1>sub Page</h1>
        <div>
            <h2> Alert</h2>
            <button type="button" @click="alertExample1"> 기본 </button>
            <button type="button" @click="alertExample2"> 타이틀 변경 </button>
            <button type="button" @click="alertExample3"> 성공시 </button>
            <button type="button" @click="alertExample4"> 경고 </button>
            <button type="button" @click="alertExample5"> Error </button>
        </div>
        <div>
            <h2> Confirm</h2>
            <button type="button" @click="confirmExample0"> confirm </button>
            <button type="button" @click="confirmExample1"> confirm </button>
            <button type="button" @click="confirmExample2"> confirm </button>
            <button type="button" @click="confirmExample3"> confirm </button>
        </div>
        <div>
            <h2> prompt</h2>
            <button type="button" @click="promptExample0"> prompt </button>
            <button type="button" @click="promptExample1"> prompt </button>
            <button type="button" @click="promptExample2"> prompt </button>
            <button type="button" @click="promptExample3"> prompt </button>
        </div>
        <div>
            <h2> advanced</h2>
            <button type="button" @click="advancedExample2"> prompt </button>
            <button type="button" @click="advancedExample3"> prompt </button>
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
