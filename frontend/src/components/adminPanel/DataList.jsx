import { Center, Table } from "@mantine/core";

const DataList = (props) => {

    // const cols = columns.map( (col => {
    //     <tr>
    //         {col.map((single) => {
    //             <th>{single}</th>
    //         })}
    //     </tr>
    // }))

    //console.log(props.data) 

    // const headers = 
    // <tr>
    //     {props.columns.map( (col) => (
    //         <th>{col.label}</th>
    //     ))}
    // </tr>

    //good
    const headers = 
        <tr>
          {/*add find and remove filtering, was ".filter((el) => el.field !== 'products')"*/}
            {props.columns.map( (col) => (
                <th>{col.label}</th>
            ))}
        </tr>

//working
  // const rows = props.data.map( (dataObj) => (
  //   <tr key={dataObj.id}>
  //     {/*if (Array.isArray(item) { return item.find('id') })*/}
  //       {props.columns.map( (field) => (
  //           <td>{dataObj[field.label]}</td>
  //       ))}
  //   </tr>
  // ))

  const rows = props.data.map((dataObj) => (
    <tr key={dataObj.id}>
      {/*if (Array.isArray(item) { return item.find('id') })*/}
      {props.columns.map((field) => {
        if (Array.isArray(dataObj[field.label])) {
         // console.log("in an array")
        //  console.log(field)
        //  console.log(dataObj[field.label])
          const result = dataObj[field.label].find( (item) => item.id != null)
          if (result)
            return <td>{result.id}</td>
          else
            return <td>{''}</td>;
          //return <td>{dataObj[field.label][0][field.id]}</td>;
        } else {
          return <td>{dataObj[field.label]}</td>;
        }
      })}
    </tr>
  ));

  // console.log(rows[0])

  return (
    <Center>
      <Table striped highlightOnHover withColumnBorders>
        <thead>{headers}</thead>
        <tbody>{rows}</tbody>
      </Table>
    </Center>
  );
};

export default DataList;
