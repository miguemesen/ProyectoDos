var IngredientList=new LinkedList();
var StepList=new LinkedList();
function AddIngredient() {
    var newLabel=document.createElement("Label");
    var text=document.getElementById("IngredientInput").value;
    newLabel.innerHTML=text;
    IngredientList.add(text);
    document.getElementById("DivisionIngredients").append(newLabel);
}
function AddStep() {
    var newLabel=document.createElement("Label");
    var text=document.getElementById("StepsInput").value;
    newLabel.innerHTML=text;
    IngredientList.add(text);
    document.getElementById("Division_Steps").append(newLabel);
}
function printConsole() {
    var i;
    for(i=0;i<IngredientList.len;i++){
        console.log("Esta imprimiendo "+i)
        console.log(IngredientList.get(i));
    }
}
function handleForm(Form) {

}