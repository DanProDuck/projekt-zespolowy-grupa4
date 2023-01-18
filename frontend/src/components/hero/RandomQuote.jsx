import {Blockquote, createStyles} from "@mantine/core";
import {useEffect, useState} from "react";
import axios from "axios";

const useStyles = createStyles((theme) => ({
    icon: {
        color: theme.colors.gray[7]
    },
    body: {
        color: theme.colors.gray[5]
    }
    })
);

const RandomQuote = () => {
    const [author, setAuthor] = useState('')
    const [content, setContent] = useState('')

    const {classes} = useStyles();

    useEffect(() => {
        async function fetchQuote() {
            const resp = await axios.get('https://api.quotable.io/random',
                {params: {tags: 'change|inspirational|literature|motivational'}});

            setAuthor(resp.data.author)
            setContent(resp.data.content)
        }

        fetchQuote();
    }, [])

    return (
        <Blockquote cite={`-${author || 'Anonymous quote'}`} maw={500} classNames={{icon: classes.icon, body: classes.body}} >
            {content}
        </Blockquote>
    );
}

export default RandomQuote;