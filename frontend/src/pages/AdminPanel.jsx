import { useState, useEffect, useRef } from "react";
import axios from "axios";
import DataList from "../components/adminPanel/DataList";
import "../components/adminPanel/AdminPanel.css"
import { Input, InputBase } from "@mantine/core";


const AdminPanel = (props) => {
  const [data, setData] = useState([]);
  const [error, setError] = useState(null);
  const [loading, setLoading] = useState(false);
  const [columns, setColumns] = useState([]);
  const [api, setApi] = useState("/api/author");

  const handleDropDown = (event) => {
    setApi(event.target.value)
  }

  useEffect(() => {
    setLoading(true);
    // axios.get(props.apiUrl)
    axios.get("http://localhost:8082" + api, { withCredentials: true })
      .then(response => {
        setData(response.data);
        setColumns(Object.keys(response.data[0]).map(field => ({ field, label: field })));
        setLoading(false);
      })
      .catch(err => {
        setError(err.message);
        setLoading(false);
      });
  // }, [props.apiUrl]);
}, [api]);

  if (loading) {
    // TODO use mantine slick loaders 👀 // im trying...
    return <p>Loading data...</p>
  }

  if (error) {
    //use error hander later // Owkey... im trying... >_<
    return <p>Error: {error}</p>
  }

  //console.log(data)
  //console.log(columns)

  return (
    <>
      <h1>Welcome to the pannel!</h1>
      <InputBase label="Choose what data you want to be shown" component="select" mt="xs" onInput={handleDropDown}>
      <option disabled selected>Please choose one option</option>
      <option value={"/api/author"}>Authors</option>
      <option value={"/api/person"}>Users</option>
      <option value={"/api/product"}>Products</option>
      </InputBase>
      <DataList data={data} columns={columns}/>
    </>
  );
}

export default AdminPanel;
