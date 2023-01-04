import { AppBar, Box, Button, IconButton, styled, Toolbar, Typography } from "@mui/material";
import { Link } from "react-router-dom";
import iMenu from "@/interfaces/iMenu";
import MenuIcon from "@mui/icons-material/Menu";
import logo from "@/assets/images/logo.png";

interface Props {
  menus: Array<iMenu>;
  handleDrawerToggle: () => void;
}

const StyledAppBar = styled((props: any) => <AppBar {...props} />)`
  background: #fff;
  color: #000;
  box-shadow: none;
  border-style: solid;
  border-color: rgb(231, 235, 240);
  border-width: 0px 0px thin;
  & button {
    color: #000;
    font-weight: bold;
  }
`;

const Header = (props: Props) => {
  const { menus, handleDrawerToggle } = props;
  return (
    <StyledAppBar component="nav">
      <Toolbar>
        <IconButton
          color="inherit"
          aria-label="open drawer"
          edge="start"
          onClick={handleDrawerToggle}
          sx={{ mr: 2, display: { sm: "none" } }}
        >
          <MenuIcon />
        </IconButton>
        <Typography variant="h6" component="div" sx={{ flexGrow: 1 }}>
          {/* CWS */}
          <Link to="/">
            <img src={logo} alt="logo" style={{ width: 112, display: "block" }} />
          </Link>
        </Typography>
        <Box sx={{ display: { xs: "none", sm: "block" } }}>
          {menus.map((menu, index) => (
            <Link to={menu.link} key={index}>
              <Button key={menu.name} sx={{ color: "#fff" }} size="large">
                {menu.name}
              </Button>
            </Link>
          ))}
        </Box>
      </Toolbar>
    </StyledAppBar>
  );
};

export default Header;
