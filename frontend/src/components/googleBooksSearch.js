import React, { useState, useEffect } from "react";
import axios from "axios";
import { Button, Col, Row } from "react-bootstrap";
import NavbarComponent from "./Navbar";
import {
  createStyles,
  SimpleGrid,
  Card,
  Image,
  Text,
  Container,
  AspectRatio,
  Center,
} from "@mantine/core";
import "../App.css";
import "../Styles/searchBar.scss";
import Select from "react-select";

const useStyles = createStyles((theme) => ({
  card: {
    transition: "transform 150ms ease, box-shadow 150ms ease",

    "&:hover": {
      transform: "scale(1.01)",
      boxShadow: theme.shadows.md,
    },
  },

  title: {
    fontFamily: `Greycliff CF, ${theme.fontFamily}`,
    fontWeight: 600,
  },
}));

function GoogleBooksSearch() {
  const { classes } = useStyles();
  const [book, setBook] = useState("");
  const [result, setResult] = useState([]);
  const [scroll, setScroll] = useState();

  // const product = props.product;
  // const cart = useContext(CartContext);
  // const productQuantity = cart.getProductQuantity(book.id);
  //const [apiKey, setApiKey] = useState("AIzaSyDtzZSStIm_x5mFwzUpj2kR2vd47O6550A");

  var a = 20;

  function handleSubmit(event) {
    event.preventDefault();
    ///axios.get("https://www.googleapis.com/books/v1/volumes?q=" + book + "&key=" + apiKey + "&maxResults=40")
    axios
      .get(
        "https://www.googleapis.com/books/v1/volumes?q=" +
          book +
          "&maxResults=40"
      )
      .then((data) => {
        console.log(data.data.items);
        setResult(data.data.items);
      });
  }

  function handleChange(event) {
    const book = event.target.value;
    setBook(book);
  }

  function truncate(str, n) {
    return str.length > n ? str.slice(0, n - 1) + "..." : str;
  }

  function authorCheck(str) {
    if (str === undefined) {
      return "We found no author of this book 😔 ";
    }
    //str = truncate(str,30)
    const a = truncate(str, 30);
    return a;
  }
  function rando() {
    var a = Math.floor(Math.random() * 12);
    console.log(a);
    return a;
  }

  useEffect(() => {
    axios
      .get("https://www.googleapis.com/books/v1/volumes?q=book&maxResults=20")
      .then((data) => {
        console.log(data.data.items);
        setResult(data.data.items);
      });
  }, []);
  var date = new Date();
  var year = date.getFullYear();
  return (
    <>
      <form onSubmit={handleSubmit}>
        <Center>
          <div className=" card-header main-search">
            <div className="col-12 col-md-3 col-xl-3">
              <div className="containerSearch" style={{ marginBottom: "45px" }}>
                <input
                  style={{ marginTop: "25px" }}
                  onChange={handleChange}
                  className="AutoFocus"
                  type="text"
                />
                <div className="search"></div>
              </div>
            </div>
          </div>
        </Center>
      </form>
      <div
        className="container"
        style={{
          borderRadius: "15px",
          paddingBottom: "30px",
          background: "linear-gradient(120.08deg, #005AA7 0.53%, #FFFDE4 100%)",
        }}
      >
        <Row xs={1} md={4} className="g-4">
          {result.map((book) => (
            <Col key={book.id}>
              <Card
                href={book.volumeInfo.canonicalVolumeLink}
                style={{
                  marginTop: "10px",
                  boxShadow:
                    "0 4px 8px 0 rgba(0, 0, 0, 0.2), 0 6px 20px 0 rgba(0, 0, 0, 0.19)",
                }}
                p="md"
                radius="md"
                component="a"
                className={classes.card}
              >
                <AspectRatio ratio={1920 / 1080}>
                  <Image
                    src={
                      book.volumeInfo.imageLinks !== undefined
                        ? book.volumeInfo.imageLinks.thumbnail
                        : ""
                    }
                    alt={book.title}
                  />
                </AspectRatio>
                <Text
                  color="dimmed"
                  size="xs"
                  transform="uppercase"
                  weight={700}
                  mt="md"
                >
                  {authorCheck(book.volumeInfo.authors)}
                </Text>
                <Text className={classes.title} mt={5}>
                  {truncate(book.volumeInfo.title, 30)}
                </Text>
              </Card>
            </Col>
          ))}
        </Row>
      </div>
    </>
  );
}

export default GoogleBooksSearch;
