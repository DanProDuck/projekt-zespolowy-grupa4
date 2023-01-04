
//import 'bootstrap/dist/css/bootstrap.min.css';
import '../App.css';
import { createStyles, Anchor, Group, ActionIcon, Center } from '@mantine/core';
import { IconBrandTwitter, IconBrandYoutube, IconBrandInstagram, IconBrandGithub } from '@tabler/icons';
import { MantineLogo } from '@mantine/ds';
import logo from '../logo_bookly_text.png';

const useStyles = createStyles((theme) => ({
  footer: {
    marginTop: 120,
    borderTop: `1px solid ${
      theme.colorScheme === 'dark' ? theme.colors.dark[5] : theme.colors.gray[2]
    }`,
  },

  inner: {
    display: 'flex',
    justifyContent: 'space-between',
    alignItems: 'center',
    padding: `${theme.spacing.md}px ${theme.spacing.md}px`,

    [theme.fn.smallerThan('sm')]: {
      flexDirection: 'column',
    },
  },

  links: {
    [theme.fn.smallerThan('sm')]: {
      //marginTop: theme.spacing.lg,
      marginBottom: theme.spacing.sm,
    },
  },
}));

function F2oter( links ) {

    console.log(links);

    var date = new Date();
    var year = date.getFullYear();
  const { classes } = useStyles();

  const items = links.links.links.map((link) => (
    <a href={link.link}>
    <Anchor
      color="dimmed"
      key={link.label}
      sx={{ lineHeight: 1 }}
      //onClick={(event) => event.preventDefault()}
      size="sm"
    >
      {link.label}
    </Anchor>
    </a>
  ));

  //<div className={classes.footer} style ={{'marginTop': '50px','zIndex':'-1', 'position': 'relative', 'bottom': '0px'}}>
  return (
    <div className={classes.footer} style ={{'marginTop': '50px','zIndex':'-1', 'bottom': '0px'}}>
        <div style = {{ 'borderRadius':'15px','background': 'linear-gradient(120.08deg, #995AE7 0.53%, #AAFDE4 100%)' }}>
            <div className={classes.inner}>
                <a href="#">
                    <img width= "50%" src={logo} alt="logoBrand"/>
                </a>

        <Group className={classes.links}>{items}</Group>

        <Group spacing="xs" position="right" noWrap>
{          /*<ActionIcon size="lg" variant="default" radius="xl">
            <IconBrandTwitter size={18} stroke={1.5} />
          </ActionIcon>
          <ActionIcon size="lg" variant="default" radius="xl">
            <IconBrandYoutube size={18} stroke={1.5} />
          </ActionIcon>*/}
          <a href = "https://github.com/DanProDuck/projekt-zespolowy-grupa4">
          <ActionIcon size="lg" variant="default" radius="xl">
            <IconBrandGithub size={18} stroke={1.5}/>
          </ActionIcon>
          </a>
          
        </Group>
      </div>
      <Center>
        <hr style = {{'width':'80%'}}/>
      </Center>
      <div>
        <span>
            © Bookly. All Rights Reserved.
        </span> 
        </div>
        <div>
        2022 - {year} 
        </div>
        </div>
    </div>
  );
}

export default F2oter;