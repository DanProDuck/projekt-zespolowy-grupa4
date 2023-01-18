import React from "react";
import {Center, Container, Text, Title} from '@mantine/core';

const About = () => {
    return (
        <>
            <Container variant="gradient" gradient={{from: 'indigo', to: 'cyan', deg: 45}}>
                <Center>
                    <Title variant="gradient"
                           gradient={{from: 'indigo', to: 'cyan', deg: 45}}
                           sx={{fontFamily: 'Greycliff CF, sans-serif'}}
                           ta="center"
                           fz={50}
                           fw={900}
                           order={1}>About us </Title>
                </Center>
                <>
                    <Text>
                        <Text
                            component="span"
                            inherit
                            variant="gradient"
                            gradient={{from: 'pink', to: 'yellow'}}
                        >Bookly </Text> - The main idea of the project is to create library system that makes it
                        possible
                        to sell and rent books and other products such as multimedia, games and software.
                    </Text>
                    <Text>
                        The users of the system will be able to browse the digital software as well as implement it
                        certain operations related to the acquisition of these goods and their provision.
                        The server that supports the application is based on a database that stores the most important
                        elements, among others digital items appearing on the website and available
                        users.
                    </Text>
                    <Text>
                        Thanks to this, the functionality will include the ability to store a large amount
                        data on the server as well as quick ordering of collected data.
                    </Text>
                </>
                <Center>
                    <Title variant="gradient"
                           gradient={{from: 'indigo', to: 'cyan', deg: 45}}
                           sx={{fontFamily: 'Greycliff CF, sans-serif'}}
                           ta="center"
                           fz={20}
                           fw={700}
                           order={1}>Creators </Title>
                </Center>
                <>
                    <Center>
                        <Text
                            component="span"
                            inherit
                            variant="gradient"
                            gradient={{from: 'pink', to: 'yellow'}}
                        >
                            Paweł Dębski,
                        </Text>{'  '}
                        <Text
                            component="span"
                            inherit
                            variant="gradient"
                            gradient={{ from: 'teal', to: 'lime', deg: 105 }}
                        >Drobotiuk Vladyslav,
                        </Text>
                        <Text
                            component="span"
                            inherit
                            variant="gradient"
                            gradient={{ from: '#ed6ea0', to: '#ec8c69', deg: 35 }}
                        >Danylo Dolhopolov,
                        </Text>
                        <Text
                            component="span"
                            inherit
                            variant="gradient"
                            gradient={{ from: 'teal', to: 'lime', deg: 105 }}
                        >Michał Bujacz
                        </Text>
                    </Center>
                </>
            </Container>
        </>
    );
}

export default About;