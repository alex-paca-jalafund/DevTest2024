import React from "react";
import { useState } from "react";
import Poll from "../../entity/Poll";
import { createPoll } from "../../services/PollService";
import FormularyTextField from "./TextFieldForm/FormularyTextFIeld";

const CreatePollForm = () =>{
    const [name, setName] = useState("")
    const [description, setDescrip] = useState("")


    const newPoll: Poll = {
        name,
        id: 0,
        options: ""
    };

    const handleSubmit = async (event: { preventDefault: () => void; }) => {
        event.preventDefault()
        console.log(name, description)
     
        const createdProduct = await createPoll(newPoll);
        console.log("Product created successfully:", createdProduct);
        setName("");
        setDescrip("");

    }
    return (
        <React.Fragment>
        <h2 className="text-blue">PRODUCT CREATE FORM</h2>
        <form onSubmit={handleSubmit}>
                <FormularyTextField
                    label="Name"
                    type="text"
                    value={name}
                    onChangeform={(e) => setName(e.target.value)}
                />
                <FormularyTextField
                    label="Description"
                    type="text"
                    value={description}
                    onChangeform={(e) => setDescrip(e.target.value)}
                />
           
                <button className="bg-cyan-500 hover:bg-cyan-600" type="submit">Create Product</button>
        </form>
        </React.Fragment>
    );
}

export default CreatePollForm;